package ru.geekbrains.lesson3;

import java.util.Comparator;

public class EmployeeAgeCoparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
}
