package com.calculator.matrix;

public abstract class CoordinateAbstract implements CoordinateInterface {
    protected int x, y;

    @Override
    public void setCoordinate(int x, int y) {
        if (x < 0 || y < 0)
            throw new IllegalArgumentException();
        this.x = x;
        this.y = y;
    }

    @Override
    public int x() {
        return x;
    }

    @Override
    public int y() {
        return y;
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof CoordinateInterface that)) return false;

        if (x != that.x()) return false;
        return y == that.y();
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
