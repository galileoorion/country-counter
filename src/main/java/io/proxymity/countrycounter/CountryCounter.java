package io.proxymity.countrycounter;

class CountryCounter {
    final Map map;

    public CountryCounter(int[][] rawMap) {
        this.map = new Map(rawMap);
    }

    public int countCountries() {
        for (int row = 0; row < map.getNumberOfRows(); row++) {
            for (int column = 0; column < map.getNumberOfColumns(); column++) {
                traverseMap(row, column);
            }
        }
        return map.getNumberOfCountries();
    }

    private void traverseMap(int row, int column) {
        Square square = getSquareAddToMapIfMissing(row, column);
        if (square.isDiscovered()) {
            map.setNumberOfCountries(map.getNumberOfCountries() + 1);
            System.out.printf("new country found: #%d%n", square.getCountry());
            visitSquare(square);
        }
    }

    private Square getSquareAddToMapIfMissing(int row, int column) {
        Square square = map.getSquares()[row][column];
        if (square == null) {
            int country = map.getA()[row][column];
            if (isOutOfRange(country)) {
                square = Square.getUnreachableSquare();
            } else {
                square = new Square(country, row, column);
            }
            map.getSquares()[row][column] = square;
        }
        return square;
    }

    void visitSquare(Square square) {
        square.setDiscovered(true);
        System.out.printf("    discovered: [%d][%d] = %d%n", square.getRow(), square.getColumn(), square.getCountry());
        visitNeighbours(map, square);
    }

    void visitNeighbours(Map map, Square square) {
        for (int row = -1; row < 2; row++) {
            for (int column = -1; column < 2; column++) {
                if (row == 0 && column == 0) continue;
                int nextRow = square.getRow() + row;
                int nextColumn = square.getColumn() + column;
                if (isValidCoordinate(nextRow, nextColumn, map)) {
                    Square neighbouringSquare = map.getSquares()[nextRow][nextColumn];
                    if (neighbouringSquare == null) {
                        neighbouringSquare = new Square(map.getA()[nextRow][nextColumn], nextRow, nextColumn);
                        map.getSquares()[nextRow][nextColumn] = neighbouringSquare;
                    }
                    if (neighbouringSquare.isDiscovered() && neighbouringSquare.getCountry() == square.getCountry()) {
                        visitSquare(neighbouringSquare);
                    }
                }
            }
        }
    }

    private boolean isValidCoordinate(int nextRow, int nextColumn, Map map) {
        return nextRow < map.getNumberOfRows()
                && nextRow > -1
                && nextColumn < map.getNumberOfColumns()
                && nextColumn > -1;
    }


    private boolean isOutOfRange(int element) {
        return element > 1_000_000_000 || element < -1_000_000_000;
    }
}
