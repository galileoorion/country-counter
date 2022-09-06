package io.proxymity.countrycounter;

public class Solution {
    public int solution(int[][] A) {
        validateMatrix(A);
        CountryCounter countryCounter = new CountryCounter(A);
        return countryCounter.countCountries();
    }

    void validateMatrix(int[][] a) {
        if (a == null) {
            throw new IllegalArgumentException("The map is null");
        } else {
            if (a.length > 300_000) {
                throw new IllegalArgumentException("Too many rows");
            }

            if (a[0].length > 300_000) {
                throw new IllegalArgumentException("Too many columns");
            }

            int elements = a.length * a[0].length;
            if (elements < 1 && elements > 300_000) {
                throw new IllegalArgumentException("The number of elements is less than 1 or greater than 300,000");
            }
        }
    }

}
