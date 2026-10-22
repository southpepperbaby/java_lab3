package ru.rasov.birds;

// Задача 4.3. Корень иерархии птиц.
// Общее у всех птиц: у каждой есть вид (название) и каждая умеет петь.
// Как именно петь, знает только конкретная птица, поэтому sing() абстрактный.
public abstract class Bird {

    private String kind;

    public Bird(String kind) {
        this.kind = kind;
    }

    public String getKind() {
        return kind;
    }

    public abstract void sing();

    @Override
    public String toString() {
        return "Птица: " + kind;
    }
}
