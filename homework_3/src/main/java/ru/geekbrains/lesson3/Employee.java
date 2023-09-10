package ru.geekbrains.lesson3;

import org.w3c.dom.CDATASection;


import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public abstract class Employee implements Comparable<Employee> {

    //region Public Methods

    /**
     * Расчет среднемесячной заработной платы
     * @return
     */
    public abstract double calculateSalary();

    @Override
    public int compareTo(Employee o) {
        return Double.compare(calculateSalary(), o.calculateSalary());
        //return calculateSalary() == o.calculateSalary() ? 0 :
        //        calculateSalary() > o.calculateSalary() ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age='" + age + '\'' +
                ", salary=" + salary +
                '}';
    }

    /**
     * Метод вывода даты рождения сотрудника
     * @param date - принимает дату из параметров экземпляра
     * @return - возвращает строку, которую можно выводить в отформатированном виде
     */
    public static String showBirthday(Date date) {
        String result = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        result = format.format(date);
        return result;
    }

    //endregion

    //region Constructors And Initializers

    {
        //System.out.println("Initialize - Employee");
        id = ++counter;
    }

    private Employee(){
    }

    protected Employee(String surName, String name, Date age){
       this.surName = surName;
       this.name = name;
       this.age = age;
       this.salary = 500;
    }

    protected Employee(String surName, String name, Date age, double salary ){
        //System.out.println("Constructor - Employee");
        if (salary < 500){
            throw new RuntimeException("Ставка заработной платы должна быть не менее 500");
        }
        this.surName = surName;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    //endregion

    //region Getters and Setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public double getSalary() {
        return salary;
    }

    public Date getAge() {return age;
    }

    public void setSalary(double salary) {
        if (salary < 30000){
            throw new RuntimeException("Уровень заработной платы должен быть не менее 30000");
        }
        this.salary = salary;
    }

    //endregion

    //region Fields

    private int id;

    /**
     * Имя
     */
    protected String name;

    /**
     * Фамилия
     */
    protected String surName;

    /**
     * Ставка заработной платы
     */
    protected double salary;

    /**
     * Дата рождения
     */

    protected Date age = new Date();
    //endregion

    //region Static Fields

    protected static String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
    protected static String[] surNames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };

    protected static Date[] birthdays = {
            new Date(2012, 12, 20),
            new Date(2000, 01, 31),
            new Date (1998, 12, 23),
            new Date (1995, 01, 22),
            new Date (1997, 02, 20),
            new Date (1999, 03, 18),
            new Date (2000, 04, 16),
            new Date (2001, 05, 14),
            new Date (2002, 06, 12),
            new Date (2003, 07, 10)};


    protected static Random random = new Random();
    private static int counter = 1000;

    //endregion

}
