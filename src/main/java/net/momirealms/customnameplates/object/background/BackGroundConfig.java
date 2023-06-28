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

package net.momirealms.customnameplates.object.background;

import net.momirealms.customnameplates.object.SimpleChar;

public record BackGroundConfig(SimpleChar left, SimpleChar offset_1,
                               SimpleChar offset_2, SimpleChar offset_4,
                               SimpleChar offset_8, SimpleChar offset_16,
                               SimpleChar offset_32, SimpleChar offset_64,
                               SimpleChar offset_128, SimpleChar right,
                               int left_margin, int right_margin) {
}
