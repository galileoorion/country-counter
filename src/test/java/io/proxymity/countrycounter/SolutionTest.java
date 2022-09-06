package io.proxymity.countrycounter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("maps")
    void solution(int[][] map, int numberOfCountries) {
        assertEquals(numberOfCountries, solution.solution(map));
    }

    static Stream<Arguments> maps() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2, 2}, {3, 4, 2}, {5, 6, 2}, {6, 6, 6}, {7, 7, 9}, {8, 9, 9}, {10, 11, 11}}, 11),
                Arguments.of(new int[][]{{1, 1, 1}, {2, 3, 2}, {2, 2, 2}, {6, 1, 1}, {7, 1, 4}, {1, 1, 4}}, 7),
                Arguments.of(new int[][]{{1, 1, 1}, {2, 3, 2}, {2, 2, 2}, {Integer.MAX_VALUE, 1, 1}, {Integer.MIN_VALUE, 1, 4}, {1, 1, 4}}, 5));
    }
}