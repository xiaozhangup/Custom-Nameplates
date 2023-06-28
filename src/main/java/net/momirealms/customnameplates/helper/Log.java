/*
 * This file is part of helper, licensed under the MIT License.
 *
 *  Copyright (c) lucko (Luck) <luck@lucko.me>
 *  Copyright (c) contributors
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package net.momirealms.customnameplates.helper;

import net.momirealms.customnameplates.CustomNameplates;
import org.bukkit.Bukkit;

import javax.annotation.Nonnull;
import java.util.logging.Level;

/**
 * Utility for quickly accessing a logger instance without using {@link Bukkit#getLogger()}
 */
public final class Log {

    public static void info(@Nonnull String s) {
        CustomNameplates.getInstance().getLogger().info(s);
    }

    public static void warn(@Nonnull String s) {
        CustomNameplates.getInstance().getLogger().warning(s);
    }

    public static void severe(@Nonnull String s) {
        CustomNameplates.getInstance().getLogger().severe(s);
    }

    public static void warn(@Nonnull String s, Throwable t) {
        CustomNameplates.getInstance().getLogger().log(Level.WARNING, s, t);
    }

    public static void severe(@Nonnull String s, Throwable t) {
        CustomNameplates.getInstance().getLogger().log(Level.SEVERE, s, t);
    }

    private Log() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

}
