package ru.rasov.geometry;

// Задача 3.5. Трёхмерная точка: та же Точка, плюс координата Z.
public class Point3D extends Point {

    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y); // x и y сохраняет конструктор родителя
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    // Родитель сравнивает x и y, мы добавляем сравнение z
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Point3D other = (Point3D) obj;
        return z == other.z;
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + z;
    }

    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }
}
