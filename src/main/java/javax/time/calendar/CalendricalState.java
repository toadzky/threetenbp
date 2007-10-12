/*
 * Copyright (c) 2007, Stephen Colebourne & Michael Nascimento Santos
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  * Neither the name of JSR-310 nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package javax.time.calendar;

import javax.time.duration.DurationUnit;

/**
 * Internal state class providing calendrical information and calculations.
 * <p>
 * CalendricalState is an abstract class and must be implemented with care to
 * ensure other classes in the framework operate correctly.
 * All instantiable subclasses must be final, immutable and thread-safe.
 *
 * @author Stephen Colebourne
 */
public abstract class CalendricalState {

    /**
     * Gets the duration unit that this state represents.
     * <p>
     * For example, if this represents a time in minutes of the day, then the
     * range is 'minute'.
     *
     * @return the duration unit, never null
     */
    public abstract DurationUnit getDurationUnit();

    /**
     * Gets the duration range that this state represents.
     * <p>
     * For example, if this represents a time in minutes of the day, then the
     * range is 'day'.
     *
     * @return the duration range, never null
     */
    public abstract DurationUnit getDurationRange();

    /**
     * Checks is the specified field is supported.
     *
     * @param fieldRule  the field rule to check, null returns false
     * @return true if the field is supported, false if not
     */
    public abstract boolean isSupported(TimeFieldRule fieldRule);

    /**
     * Gets the value of the specified field.
     *
     * @param fieldRule  the field rule to query, not null
     * @return the value for the requested field
     * @throws NullPointerException if the specified field rule is null
     * @throws UnsupportedCalendarFieldException if the field is not supported
     */
    public abstract int get(TimeFieldRule fieldRule);

}
