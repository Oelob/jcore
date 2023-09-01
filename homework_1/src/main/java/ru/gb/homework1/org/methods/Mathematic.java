package ru.gb.homework1.org.methods;

/**
 * класс, в котором будет 2 математических метода
 */
public class Mathematic {

    /**
     * Метод возведения в квадрат
     * @param a - возведимое в степень число
     * @param b - степень, в которую нужно возвести
     * @return
     */
    public static double pow(int a, int b){
        return Math.pow(a,b);
    }

    /**
     * Метод вычисления квадратного корня числа
     * @param a - число, квадратный корень которого необходимо вычислить
     * @return
     */
    public static double sqr(int a){
        return Math.sqrt(a);
    }
}
