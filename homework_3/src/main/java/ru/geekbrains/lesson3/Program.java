package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static ru.geekbrains.lesson3.Employee.random;
import static ru.geekbrains.lesson3.Employee.randomChoice;

public class Program {

    public static void main(String[] args) {

//       List<Employee> employees = Freelancer.getEmployees(15);
//
//        List<Employee> employees = getAllEmployees(15);
//        for (Employee employee: employees) {
//            System.out.println(employee);
//        }

        Staff lst1 = new Staff(10);

//

//        Collections.sort(employees, new EmployeeNameComparator());
//        System.out.println();
//
        for (Employee empl: lst1) {
            System.out.println(empl);
        }
    }

    /**
     * Метод создания общего списка рабочих
     * @param count - количество сотрудников
     * @return
     */
    public static List<Employee> getAllEmployees(int count){
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++)
           if (randomChoice())
               employees.add(Freelancer.getInstance());
           else
               employees.add(Worker.getInstance());
        return employees;
    }

}
