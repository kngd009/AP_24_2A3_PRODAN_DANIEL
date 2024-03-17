package org.example;

import java.util.Objects;

class Pair<T, U> {
    private final T open;
    private final U close;

    public Pair(T open, U close) {
        this.open = open;
        this.close = close;
    }

    public T open() {
        return open;
    }

    public U close() {
        return close;
    }

    @Override
    public String toString() {
        return "(" + open + ", " + close + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) obj;
        return Objects.equals(open, pair.open) && Objects.equals(close, pair.close);
    }
}