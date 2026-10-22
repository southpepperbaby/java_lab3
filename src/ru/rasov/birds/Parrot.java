package ru.rasov.birds;

import java.util.Random;

public class Parrot extends Bird {

    private String text;
    private Random random = new Random();

    public Parrot(String text) {
        super("Попугай");
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Попугаю нужен непустой текст");
        }
        this.text = text;
    }

    public String getText() {
        return text;
    }

    // Поёт первые N символов текста, N случайное от 1 до длины текста
    @Override
    public void sing() {
        int n = random.nextInt(text.length()) + 1;
        System.out.println(text.substring(0, n));
    }

    @Override
    public String toString() {
        return super.toString() + ", знает текст \"" + text + "\"";
    }
}
