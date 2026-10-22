 package ru.rasov.time;

// Время суток. Хранится как количество секунд с начала суток.
// ЛР2: вывод "Ч:ММ:СС", два конструктора, методы getHours(), getMinutes(), getSeconds(). ЛР3, задача 1.2: в поле всегда лежит время от начала суток (0..86399).
public class Time {

    private static final int SECONDS_IN_DAY = 24 * 60 * 60; // 86400
    private static final int SECONDS_IN_HOUR = 60 * 60;     // 3600
    private static final int SECONDS_IN_MINUTE = 60;

    // final: после присвоения в конструкторе поле поменять уже нельзя.
    private final int totalSeconds;

    // Время по количеству секунд с начала суток
    public Time(int totalSeconds) {
        if (totalSeconds < 0) {
            throw new IllegalArgumentException("Время не может быть отрицательным");
        }
        // всё, что превышает 24 часа, отбрасываем: 100000 -> 13600
        this.totalSeconds = totalSeconds % SECONDS_IN_DAY;
    }

    // Время по часам, минутам и секундам.
    public Time(int hours, int minutes, int seconds) {
        this(hours * SECONDS_IN_HOUR + minutes * SECONDS_IN_MINUTE + seconds);
    }

    public int getTotalSeconds() {
        return totalSeconds;
    }

    // Какой сейчас час. Теперь число в поле всегда меньше суток, поэтому % SECONDS_IN_DAY не нужен.
    public int getHours() {
        return totalSeconds / SECONDS_IN_HOUR;
    }

    // Сколько минут прошло с начала текущего часа
    public int getMinutes() {
        return totalSeconds % SECONDS_IN_HOUR / SECONDS_IN_MINUTE;
    }

    // Сколько секунд прошло с начала текущей минуты
    public int getSeconds() {
        return totalSeconds % SECONDS_IN_MINUTE;
    }

    // переопределяем toString, иначе выведет мусор вида Time@1b6d...
    @Override
    public String toString() {
        return getHours() + ":" + twoDigits(getMinutes()) + ":" + twoDigits(getSeconds());
    }

    // 5 -> "05", 42 -> "42"
    private String twoDigits(int number) {
        if (number < 10) {
            return "0" + number;
        }
        return "" + number;
    }
}
