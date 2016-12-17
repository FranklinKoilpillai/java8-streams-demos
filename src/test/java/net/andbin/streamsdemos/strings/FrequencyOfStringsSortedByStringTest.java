/*
 * Copyright (C) 2016 Andrea Binello ("andbin")
 *
 * This file is part of the "Java 8 Streams Demos" project and is licensed
 * under the MIT License. See one of the license files included in the root
 * of the project for the full text of the license.
 */

package net.andbin.streamsdemos.strings;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.google.common.collect.Maps;

import net.andbin.streamsdemos.AbstractTestBase;

public class FrequencyOfStringsSortedByStringTest extends AbstractTestBase {
    private final SUT sut;

    public FrequencyOfStringsSortedByStringTest(String instanceInfo, SUT sut) {
        super(instanceInfo);
        this.sut = sut;
    }

    @Factory
    public static Object[] instances() {
        return new Object[] {
                new FrequencyOfStringsSortedByStringTest("mapNamesFrequencyUsingLambdaExpr",
                        FrequencyOfStringsSortedByString::mapNamesFrequencyUsingLambdaExpr),
                new FrequencyOfStringsSortedByStringTest("mapNamesFrequencyUsingMethodRef",
                        FrequencyOfStringsSortedByString::mapNamesFrequencyUsingMethodRef),
        };
    }

    private interface SUT {
        Map<String,Long> mapNamesFrequency(List<String> namesList);
    }


    //--------------------------------------------------------------------------
    // TESTS
    //--------------------------------------------------------------------------

    private static final List<String> LIST1 = Arrays.asList("two", "four",
            "one", "four", "three", "two", "four", "three", "three", "four");

    @Test
    public void givenEmptyListShouldReturnEmptyMap() {
        Map<String,Long> nameToFrequencyMap = sut.mapNamesFrequency(Collections.emptyList());
        assertThat(nameToFrequencyMap).isEmpty();
    }

    @Test
    public void givenList1ShouldReturnExpectedMap() {
        Map<String,Long> nameToFrequencyMap = sut.mapNamesFrequency(LIST1);
        assertThat(nameToFrequencyMap).containsExactly(
                Maps.immutableEntry("four", 4L),
                Maps.immutableEntry("one", 1L),
                Maps.immutableEntry("three", 3L),
                Maps.immutableEntry("two", 2L)
        );
    }
}
