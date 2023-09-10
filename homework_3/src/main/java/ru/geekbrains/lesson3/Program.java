package ru.geekbrains.lesson3;

import java.util.List;

public class Program {

    public static void main(String[] args) {

        List<Employee> employees = Freelancer.getEmployees(15);
//
        for (Employee employee: employees) {
            System.out.println(employee);
        }
//
//        Collections.sort(employees, new EmployeeNameComparator());
//        System.out.println();
//
//        for (Employee employee: employees) {
//            System.out.println(employee);
//        }
//        Employee f1 = new Freelancer("Петр", "Иванов");
//        System.out.println(f1);
    }

}
