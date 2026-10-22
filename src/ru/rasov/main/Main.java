package ru.rasov.main;

import java.util.Scanner;

import ru.rasov.birds.Bird;
import ru.rasov.birds.Cuckoo;
import ru.rasov.birds.Parrot;
import ru.rasov.birds.Sparrow;
import ru.rasov.company.Department;
import ru.rasov.company.Employee;
import ru.rasov.geometry.Point;
import ru.rasov.geometry.Point3D;
import ru.rasov.time.Time;
import ru.rasov.tree.Node;

// Задача 7.2: единственная точка входа в программу во всём проекте.
public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Лабораторная работа №3, вариант 7");

        while (true) {
            System.out.println();
            System.out.println("1 - Время от начала суток (1.2)");
            System.out.println("2 - Начальник отдела (1.11, 8.1)");
            System.out.println("3 - Бинарное дерево (2.4)");
            System.out.println("4 - Трёхмерная точка и сравнение точек (3.5, 6.2)");
            System.out.println("5 - Птицы и птичий рынок (4.3, 5.2)");
            System.out.println("6 - Возведение в степень (7.3)");
            System.out.println("0 - Выход");

            int choice = readInt("Выберите пункт: ");
            switch (choice) {
                case 1: demoTime(); break;
                case 2: demoDepartment(); break;
                case 3: demoTree(); break;
                case 4: demoPoints(); break;
                case 5: demoBirds(); break;
                case 6: demoPower(args); break;
                case 0:
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Такого пункта нет");
            }
        }
    }

    // ---------- 1.2 ----------
    private static void demoTime() {
        System.out.println("--- Задача 1.2. Время от начала суток ---");
        System.out.println("100000 секунд больше суток, лишнее отбрасывается:");
        System.out.println("new Time(100000) -> " + new Time(100000));
        System.out.println("new Time(25, 30, 0) -> " + new Time(25, 30, 0));

        System.out.println("Пробуем создать время -5 секунд:");
        try {
            new Time(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        int seconds = readInt("Введите своё количество секунд: ");
        try {
            Time time = new Time(seconds);
            System.out.println("Время: " + time);
            System.out.println("Час: " + time.getHours()
                    + ", минута: " + time.getMinutes()
                    + ", секунда: " + time.getSeconds());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    // ---------- 1.11 и 8.1 ----------
    private static void demoDepartment() {
        System.out.println("--- Задачи 1.11 и 8.1. Начальник отдела ---");

        Department it = new Department("IT");
        Employee petrov = new Employee("Петров", it);
        Employee kozlov = new Employee("Козлов", it);
        Employee sidorov = new Employee("Сидоров", it);
        it.setBoss(kozlov);

        Department sales = new Department(readLine("Название второго отдела: "));
        Employee newBoss = new Employee(readLine("Имя сотрудника этого отдела: "), sales);

        System.out.println();
        System.out.println(petrov);
        System.out.println(kozlov);
        System.out.println(sidorov);
        System.out.println(newBoss);

        System.out.println();
        System.out.println("Новый начальник отдела IT: " + newBoss.getName());
        it.setBoss(newBoss);
        System.out.println(newBoss + "  <- его автоматически перевели в IT");
        System.out.println(kozlov + "  <- Козлов теперь обычный сотрудник");
        System.out.println(it);
        System.out.println(sales);

        System.out.println();
        System.out.println("Возвращаем сотрудника " + newBoss.getName() + " в отдел " + sales.getName());
        newBoss.setDepartment(sales);
        System.out.println(it + "  <- в IT больше нет начальника из чужого отдела");
        System.out.println(newBoss);
    }

    // ---------- 2.4 ----------
    private static void demoTree() {
        Node tree = new Node();
        int[] numbers = {3, 5, 4, 7, 1, 2};
        for (int n : numbers) {
            tree.add(n);
        }
        System.out.println("Добавили 3 5 4 7 1 2, дерево: " + tree);

        int added = readInt("Какое число добавить? ");
        tree.add(added);
        System.out.println("Дерево: " + tree);

        int searched = readInt("Какое число проверить? ");
        System.out.println("Есть в дереве: " + tree.contains(searched));

        int removed = readInt("Какое число удалить? ");
        if (tree.remove(removed)) {
            System.out.println("Удалили, дерево: " + tree);
        } else {
            System.out.println("Такого числа в дереве нет");
        }
    }

    // ---------- 3.5 и 6.2 ----------
    private static void demoPoints() {
        System.out.println("Первая точка:");
        Point a = new Point(readInt("x = "), readInt("y = "));
        System.out.println("Вторая точка:");
        Point b = new Point(readInt("x = "), readInt("y = "));

        System.out.println(a + " и " + b);
        System.out.println("a == b      : " + (a == b) + "  (это разные объекты)");
        System.out.println("a.equals(b) : " + a.equals(b) + "  (сравниваем координаты)");

        System.out.println("Трёхмерная точка:");
        Point3D p3 = new Point3D(readInt("x = "), readInt("y = "), readInt("z = "));
        System.out.println("Точка " + p3 + ", z = " + p3.getZ());

        Point asPoint = p3; // трёхмерная точка тоже Точка
        System.out.println("Через ссылку типа Point она печатается так: " + asPoint);
        System.out.println("Её копия равна ей: " + p3.equals(new Point3D(p3.getX(), p3.getY(), p3.getZ())));
    }

    // ---------- 4.3 и 5.2 ----------
    private static void demoBirds() {
        String text = readLine("Какому тексту научить попугая? ");
        Bird[] birds = {
                new Sparrow(),
                new Sparrow(),
                new Cuckoo(),
                new Cuckoo(),
                new Parrot(text),
                new Parrot("Попопопо")
        };
        Methods.singAll(birds);
    }

    // ---------- 7.3 ----------
    private static void demoPower(String[] args) {
        String x;
        String y;
        if (args.length >= 2) {
            x = args[0];
            y = args[1];
            System.out.println("Берём числа из командной строки: " + x + " и " + y);
        } else {
            System.out.println("В командной строке чисел нет, введите их сами");
            x = readLine("X = ");
            y = readLine("Y = ");
        }
        try {
            System.out.println(x + " в степени " + y + " = " + Methods.power(x, y));
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: это не целые числа");
        }
    }

    // ---------- ввод с проверкой ----------

    // Просим целое число, пока пользователь не введёт правильно
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Нужно целое число, попробуйте ещё раз");
            }
        }
    }

    // Просим непустую строку
    private static String readLine(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
            System.out.println("Строка не должна быть пустой");
        }
    }
}
