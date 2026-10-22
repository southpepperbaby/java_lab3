package ru.rasov.company;

import java.util.ArrayList;

// Сотрудник: имя и отдел, в котором он работает.
// ЛР2: текстовая форма зависит от того, начальник он или нет; список сотрудников отдела.
// ЛР3, задачи 1.11 и 8.1: перевод в другой отдел.
public class Employee {

    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        setDepartment(department); // сотрудник сам записывается в список своего отдела
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    // Перевести сотрудника в другой отдел.
    public void setDepartment(Department newDepartment) {
        if (newDepartment == null) {
            throw new IllegalArgumentException("Сотрудник должен работать в каком-то отделе");
        }
        if (department != null) {
            // уходим из старого отдела: убираем себя из его списка
            department.employees.remove(this);
            // если был там начальником, перестаём им быть,
            // иначе начальник работал бы не в своём отделе
            if (department.boss == this) {
                department.boss = null;
            }
        }
        // поля boss и employees чужого класса доступны напрямую,
        // потому что Department в том же пакете (задача 8.1)
        department = newDepartment;
        department.employees.add(this);
    }

    // Все сотрудники того же отдела (включая этого сотрудника)
    public ArrayList<Employee> getDepartmentEmployees() {
        return department.getEmployees();
    }

    @Override
    public String toString() {
        Employee boss = department.getBoss();

        // == сравнивает ссылки: это тот же самый объект или нет
        if (boss == this) {
            return name + " начальник отдела " + department.getName();
        }
        if (boss == null) {
            return name + " работает в отделе " + department.getName() + ", начальник пока не назначен";
        }
        return name + " работает в отделе " + department.getName() + ", начальник которого " + boss.getName();
    }
}
