/*
 *  Copyright (C) <2022> <XiaoMoMi>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.momirealms.customnameplates.object.requirements;

import net.momirealms.customnameplates.object.requirements.papi.*;
import org.bukkit.configuration.MemorySection;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomPapiImpl implements Requirement {

    private final List<PapiRequirement> papiRequirement;

    public CustomPapiImpl(Map<String, Object> expressions){
        papiRequirement = getRequirements(expressions);
    }

    @Override
    public boolean isConditionMet(Player player) {
        for (PapiRequirement requirement : papiRequirement) {
            if (!requirement.isMet(player)) {
                return false;
            }
        }
        return true;
    }

    private List<PapiRequirement> getRequirements(Map<String, Object> map) {
        List<PapiRequirement> papiRequirements = new ArrayList<>();
        map.keySet().forEach(key -> {
            if (key.startsWith("&&")) {
                if (map.get(key) instanceof MemorySection map2) {
                    papiRequirements.add(new ExpressionAnd(getRequirements(map2.getValues(false))));
                }
            } else if (key.startsWith("||")) {
                if (map.get(key) instanceof MemorySection map2) {
                    papiRequirements.add(new ExpressionOr(getRequirements(map2.getValues(false))));
                }
            } else {
                if (map.get(key) instanceof MemorySection map2) {
                    String type = map2.getString("type");
                    String papi = map2.getString("papi");
                    String value = map2.getString("value");
                    if (value == null || papi == null || type == null) return;
                    switch (type){
                        case "==" -> papiRequirements.add(new PapiEquals(papi, value));
                        case "!=" -> papiRequirements.add(new PapiNotEquals(papi, value));
                        case ">=" -> papiRequirements.add(new PapiNoLess(papi, value));
                        case "<=" -> papiRequirements.add(new PapiNoLarger(papi, value));
                        case "<" -> papiRequirements.add(new PapiSmaller(papi, value));
                        case ">" -> papiRequirements.add(new PapiGreater(papi, value));
                    }
                }
            }
        });
        return papiRequirements;
    }
}
