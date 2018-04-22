package com.alayam.algo;

public class EqualsExample {
    private int x;
    private float y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        EqualsExample that = (EqualsExample) o;

        if (x != that.x) return false;
        return Float.compare(that.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result +
                (y != + 0.0f ? Float.floatToIntBits(y) : 0);
        return result;
    }
}
