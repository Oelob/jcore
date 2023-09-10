package ru.geekbrains.lesson3;


import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
                ", birthday='" + birthday + '\'' +
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

    /**
     * Метод случайного выбора (используется в создании общего списка сотрудников)
     * @return
     */
    public static Boolean randomChoice(){
        return random.nextBoolean();
    }

    //endregion

    //region Constructors And Initializers

    {
        //System.out.println("Initialize - Employee");
        id = ++counter;
    }

    private Employee(){
    }

    protected Employee(String surName, String name, Date birthday){
       this.surName = surName;
       this.name = name;
       this.birthday = birthday;
       this.salary = 500;
    }

    protected Employee(String surName, String name, Date birthday, double salary ){
        //System.out.println("Constructor - Employee");
        if (salary < 500){
            throw new RuntimeException("Ставка заработной платы должна быть не менее 500");
        }
        this.surName = surName;
        this.name = name;
        this.birthday = birthday;
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

    public Date getBirthday() {return birthday;}

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

    protected Date birthday = new Date();
    //endregion

    //region Static Fields

    protected static String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
    protected static String[] surNames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };

    protected static Date[] birthdays = {
            new Date(112, 12, 20),
            new Date(100, 01, 31),
            new Date (98, 12, 23),
            new Date (95, 01, 22),
            new Date (97, 02, 20),
            new Date (99, 03, 18),
            new Date (100, 04, 16),
            new Date (101, 05, 14),
            new Date (102, 06, 12),
            new Date (103, 07, 10)};


    protected static Random random = new Random();
    private static int counter = 1000;

    //endregion

}
