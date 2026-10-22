package ru.rasov.main;

import ru.rasov.birds.Bird;

// Задача 7.3: статический импорт. После него можно писать parseInt(...) и pow(...) без имени класса.
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

// Задача 7.2: методы из блока 2.5 лежат в пакете main.
public class Methods {

    // Задача 5.2. Птичий рынок.
    public static void singAll(Bird... birds) {
        for (Bird bird : birds) {
            System.out.print(bird.getKind() + ": ");
            bird.sing();
        }
    }

    // Задача 7.3. Возведение в степень: строки -> числа -> X в степени Y.
    public static double power(String x, String y) {
        return pow(parseInt(x), parseInt(y));
    }
}
