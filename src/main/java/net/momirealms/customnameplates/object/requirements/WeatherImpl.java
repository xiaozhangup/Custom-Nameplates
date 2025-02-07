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

import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.List;

public record WeatherImpl(List<String> weathers) implements Requirement {

    @Override
    public boolean isConditionMet(Player player) {
        World world = player.getWorld();
        String currentWeather;
        if (world.isThundering()) {
            if (world.isClearWeather()) currentWeather = "thunder";
            else currentWeather = "rainstorm";
        } else if (world.isClearWeather()) {
            currentWeather = "clear";
        } else {
            currentWeather = "rain";
        }
        for (String weather : weathers) {
            if (weather.equalsIgnoreCase(currentWeather)) {
                return true;
            }
        }
        return false;
    }
}
