package io.proxymity.countrycounter;

class Square {
    private final int country;
    private final int column;
    private final int row;
    private boolean discovered;

    Square(int country, int row, int column) {
        this.country = country;
        this.column = column;
        this.row = row;
        this.discovered = false;
    }

    private Square(int country, int column, int row, boolean discovered) {
        this.country = country;
        this.column = column;
        this.row = row;
        this.discovered = discovered;
    }

    static Square getUnreachableSquare() {
        return new Square(0,0,0,true);
    }

    public int getCountry() {
        return country;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public boolean isUndiscovered() {
        return !discovered;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }
}
