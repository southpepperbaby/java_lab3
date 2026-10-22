package ru.rasov.birds;

import java.util.Random;

public class Cuckoo extends Bird {

    private Random random = new Random();

    public Cuckoo() {
        super("Кукушка");
    }

    // "ку-ку" случайное число раз от 1 до 10
    @Override
    public void sing() {
        int times = random.nextInt(10) + 1; // nextInt(10) даёт 0..9, +1 -> 1..10
        for (int i = 0; i < times; i++) {
            System.out.print("ку-ку ");
        }
        System.out.println();
    }
}
