package ru.geekbrains.lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static ru.geekbrains.lesson3.Employee.random;
import static ru.geekbrains.lesson3.Employee.randomChoice;

public class Program {

    public static void main(String[] args) {
        /**
         * Дополнение класса фрилансеров и сортировка их по возрасту
         */
//       List<Employee> employees = Freelancer.getEmployees(15);
//       for (Employee employee: employees) {
//            System.out.println(employee);
//        }
//        System.out.println();
//        Collections.sort(employees, new EmployeeAgeCoparator());
//        for (Employee employee: employees) {
//            System.out.println(employee);
//        }

        /**
         * Реализация метода создания списка сотрудника и его сортировка
          */
//        List<Employee> employees = getAllEmployees(15);
//        for (Employee employee: employees) {
//            System.out.println(employee);
//        }
//        System.out.println();
//        Collections.sort(employees, new EmployeeAgeCoparator());
//        for (Employee employee: employees) {
//            System.out.println(employee);
//        }


        /**
         * Реализация объекта класса Staff с ипользованием for each
         */
        Staff lst1 = new Staff(10);
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
