package io.proxymity.countrycounter;

class Map {
    private final int[][] A;
    private final int numberOfColumns;
    private final int numberOfRows;
    private final Square[][] squares;
    private int numberOfCountries;

    public Map(int[][] A) {
        this.A = A;
        this.numberOfRows = A.length;
        this.numberOfColumns = A[0].length;
        this.squares = new Square[numberOfRows][numberOfColumns];
    }

    public int[][] getA() {
        return A;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public Square[][] getSquares() {
        return squares;
    }

    public int getNumberOfCountries() {
        return numberOfCountries;
    }

    public void setNumberOfCountries(int numberOfCountries) {
        this.numberOfCountries = numberOfCountries;
    }
}
