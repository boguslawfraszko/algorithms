package org.example.algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QuicksortTest {


    @Test
    public void testQuickSortSimpleList() {
        var input = List.of(12,15,1,5,6,14,11);

        assertThat(Quicksort.quickSort(input)).isEqualTo(List.of(1,5,6,11,12,14,15));

    }


}
