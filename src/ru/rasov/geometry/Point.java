package ru.rasov.geometry;

// Точка на плоскости (1.1.1). Сравнение по координатам: задача 6.2.
public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Две точки равны, если у них одинаковые координаты
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;              // это один и тот же объект
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;             // null или объект другого класса
        }
        Point other = (Point) obj;
        return x == other.x && y == other.y;
    }

    // Правило Java: равные объекты обязаны иметь одинаковый hashCode
    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}
