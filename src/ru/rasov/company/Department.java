package ru.rasov.company;

import java.util.ArrayList;

// Отдел: название, начальник и список всех сотрудников.
// ЛР2: название, начальник, список сотрудников.
// ЛР3, задачи 1.11 и 8.1: начальник всегда работает в этом же отделе.
public class Department {

    private String name;

    // Без модификатора = package-private (задача 8.1).
    // Employee лежит в этом же пакете и может менять эти поля напрямую,
    // а классы из других пакетов (например Main) их не видят.
    Employee boss;
    ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.boss = null; // начальника пока нет
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Employee getBoss() {
        return boss;
    }

    // Задача 1.11. Назначить начальника.
    // Если он работает в другом отделе, сначала переводим его сюда.
    public void setBoss(Employee boss) {
        if (boss != null && boss.getDepartment() != this) {
            boss.setDepartment(this);
        }
        this.boss = boss;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        String bossName = "не назначен";
        if (boss != null) {
            bossName = boss.getName();
        }
        return "Отдел " + name + ", начальник: " + bossName + ", сотрудников: " + employees.size();
    }
}
