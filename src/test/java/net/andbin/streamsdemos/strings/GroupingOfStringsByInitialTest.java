/*
 * Copyright (C) 2016 Andrea Binello ("andbin")
 *
 * This file is part of the "Java 8 Streams Demos" project and is licensed
 * under the MIT License. See one of the license files included in the root
 * of the project for the full text of the license.
 */

package net.andbin.streamsdemos.strings;

import static com.google.common.collect.Maps.immutableEntry;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import net.andbin.streamsdemos.AbstractTestBase;

public class GroupingOfStringsByInitialTest extends AbstractTestBase {
    private final SUT sut;

    public GroupingOfStringsByInitialTest(String instanceInfo, SUT sut) {
        super(instanceInfo);
        this.sut = sut;
    }

    @Factory
    public static Object[] instances() {
        return new Object[] {
                new GroupingOfStringsByInitialTest("groupByInitialUsingLambdaExpr",
                        GroupingOfStringsByInitial::groupByInitialUsingLambdaExpr),
                new GroupingOfStringsByInitialTest("groupByInitialUsingMethodRef",
                        GroupingOfStringsByInitial::groupByInitialUsingMethodRef),
        };
    }

    private interface SUT {
        Map<String,List<String>> groupByInitial(List<String> namesList);
    }


    //--------------------------------------------------------------------------
    // TESTS
    //--------------------------------------------------------------------------

    private static final List<String> LIST1 = Arrays.asList("one", "two",
            "three", "four", "five", "six");

    @Test
    public void givenEmptyListShouldReturnEmptyMap() {
        Map<String,List<String>> initialToNamesMap = sut.groupByInitial(Collections.emptyList());
        assertThat(initialToNamesMap).isEmpty();
    }

    @Test
    public void givenOneItemListShouldReturnOneEntryMap() {
        Map<String,List<String>> initialToNamesMap = sut.groupByInitial(Arrays.asList("one"));
        assertThat(initialToNamesMap).containsExactly(immutableEntry("o", Arrays.asList("one")));
    }

    @Test
    public void givenList1ShouldReturnFourEntriesMap() {
        Map<String,List<String>> initialToNamesMap = sut.groupByInitial(LIST1);
        assertThat(initialToNamesMap).isNotEmpty();
        assertThat(initialToNamesMap.keySet()).containsExactly("f", "o", "s", "t");
        assertThat(initialToNamesMap.get("f")).containsOnly("four", "five");
        assertThat(initialToNamesMap.get("o")).containsOnly("one");
        assertThat(initialToNamesMap.get("s")).containsOnly("six");
        assertThat(initialToNamesMap.get("t")).containsOnly("two", "three");
    }
}
