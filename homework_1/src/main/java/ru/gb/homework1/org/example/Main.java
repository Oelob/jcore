package ru.gb.homework1.org.example;
import ru.gb.homework1.org.methods.Mathematic;
import ru.gb.homework1.org.methods.Print;

/**
 * Метод main - точка входа в программу
 */
public class Main {
    public static void main(String[] args) {
        double result1 = Mathematic.pow(2,3);
        Print.printResult(result1);
        double result2 = Mathematic.sqr(16);
        Print.printResult(result2);
    }
}