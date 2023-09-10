package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * TODO: Доработать в рамках домашней работы
 */
public class Freelancer extends Employee{


    protected Freelancer(String surName, String name, Date age) {
        super(surName, name, age);
        this.salary = random.nextDouble(150,500);
    }

    public static Employee getInstance(){
        return new Freelancer(
                surNames[random.nextInt(surNames.length)],
                names[random.nextInt(surNames.length)],
                birthdays[random.nextInt(birthdays.length)]);
    }

    public static List<Employee> getEmployees(int count){
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++)
            employees.add(getInstance());
        return employees;
    }

    @Override
    public double calculateSalary() {
        return 20.8*8*this.salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Дата рождения - %s; Фрилансер; Среднемесячная заработная плата (почасовая): %.2f (руб.)",
                surName, name, showBirthday(age), calculateSalary());
    }
}
