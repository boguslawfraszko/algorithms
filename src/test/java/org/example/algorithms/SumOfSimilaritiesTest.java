package org.example.algorithms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SumOfSimilaritiesTest {


    @Test
    public void testSimpleCalculateSumOfSimilarities() {

        assertThat(SumOfSimilarities.calculateSumOfSimilarities("ababaa")).isEqualTo(11);

    }

    @ParameterizedTest
    @MethodSource("provideStringsForCalculateSumOfSimilarities")
    public void testCalculateSumOfSimilarities(String value, long expected) {
        assertThat(SumOfSimilarities.calculateSumOfSimilarities(value)).isEqualTo(expected);

    }

    private static Stream<Arguments> provideStringsForCalculateSumOfSimilarities() {
        return Stream.of(
                Arguments.of("ababaa", 11L),
                Arguments.of("aaabbb", 9L),
                Arguments.of("abacaba", 12L),
                Arguments.of("abacabaabacaba", 31L),
                Arguments.of("abacabadabacaba", 32L),
                Arguments.of("abcabccba", 13L)
        );
    }

}
