package ru.geekbrains.lesson2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Program {


    private static final char DOT_HUMAN = 'X'; // Фишка игрока - человек
    private static final char DOT_AI = '0'; // Фишка игрока - компьютер
    private static final char DOT_EMPTY = '*'; // Признак пустого поля



    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static char[][] field; // Двумерный массив хранит текущее состояние игрового поля

    private static int fieldSizeX; // Размерность игрового поля
    private static int fieldSizeY; // Размерность игрового поля
    private static int WIN_COUNT; // Выигрышная комбинация


    public static void main(String[] args) {
        field = new char[3][];

        while (true){
            initialize();
            printField();
            while (true){
                humanTurn();
                printField();
                if (checkGameState(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (checkGameState(DOT_AI, "Победил компьютер!"))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * ДОБАВИЛ МЕТОД УСТАНОВКИ РАЗМЕРА ИГРОВОГО ПОЛЯ
     */
    private static void coordinates() {
        System.out.print("Введите размер игрового поля по оси 'X': ");
        if (scanner.hasNextInt()){
            fieldSizeX = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.print("Введите размер игрового поля по оси 'Y': ");
        if (scanner.hasNextInt()){
            fieldSizeY = scanner.nextInt();
            scanner.nextLine();
        }
    }

    /**
     * ДОБАВИЛ МЕТОД ОПРЕДЕЛЕНИЯ РАЗМЕРА ПОБЕДНОЙ КОМБИНАЦИИ
     */
    private static void setWinParametr(){
        System.out.print("Введите размер победной комбинации: ");
        if (scanner.hasNextInt()){
            WIN_COUNT = scanner.nextInt();
            scanner.nextLine();
        }
    }
    /**
     * Инициализация объектов игры
     * ДОБАВИЛ ОПРЕДЕЛЕНИЕ РАЗМЕРОВ ПОЛЯ И ПОБЕДНОЙ КОМБИНАЦИИ В МЕТОД ИНИЦИАЛИЗАЦИИ ПОЛЯ
     */
    private static void initialize(){
       coordinates();
       setWinParametr();
        field = new char[fieldSizeX][fieldSizeY];
        for (int y = 0; y < fieldSizeY; y++){
            for (int x = 0; x < fieldSizeX; x++){
                field[x][y] = DOT_EMPTY;
            }
        }

    }

    /**
     * Отрисовка игрового поля
     *
     *     +-1-2-3-
     *     1|*|X|0|
     *     2|*|*|0|
     *     3|*|*|0|
     *     --------
     */
    private static void printField(){
        System.out.print("+");
        for (int x = 0; x < fieldSizeX * 2 + 1; x++){
            System.out.print((x % 2 == 0) ? "-" : x / 2 + 1);
        }
        System.out.println();

        for (int y = 0; y < fieldSizeY; y++){
            System.out.print(y + 1 + "|");
            for (int x = 0; x < fieldSizeX; x++){
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }

        for (int x = 0; x < fieldSizeX * 2 + 2; x++){
            System.out.print("-");
        }
        System.out.println();

    }

    /**
     * Обработка хода игрока (человек)
     *ДОБАВИЛ В КОД АВТОМАТИЧЕСКОЕ ЗАПОЛНЕНИЕ ДЛИНЫ ПОЛЯ В ЗАПРОСЕ КООРДНАТ
     */
    private static void humanTurn(){
        int x, y;

        do {

            while (true){
                System.out.printf("Введите координату хода X (от 1 до %d): ", fieldSizeX);
                if (scanner.hasNextInt()){
                    x = scanner.nextInt() - 1;
                    scanner.nextLine();
                    break;
                }
                else {
                    System.out.println("Некорректное число, повторите попытку ввода.");
                    scanner.nextLine();
                }
            }

            while (true){
                System.out.printf("Введите координату хода Y (от 1 до %d): ", fieldSizeY);
                if (scanner.hasNextInt()){
                    y = scanner.nextInt() - 1;
                    scanner.nextLine();
                    break;
                }
                else {
                    System.out.println("Некорректное число, повторите попытку ввода.");
                    scanner.nextLine();
                }
            }
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }
    /**
     * Проверка, ячейка является пустой (DOT_EMPTY)
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;
    }
    /**
     * Проверка корректности ввода
     * (координаты хода не должны превышать размерность игрового поля)
     * @param x
     * @param y
     * @return
     */
    private static boolean isCellValid(int x, int y){
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Обработка хода компьютера
     */
    private static void aiTurn(){
        int x, y;

        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
    }

    /**
     * Проверка состояния игры
     * @param c фишка игрока
     * @param s победный слоган
     * @return
     */
    private static boolean checkGameState(char c, String s){
        if (checkWinV2(c)) {
            System.out.println(s);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }

        return false; // Игра продолжается
    }

    /**
     * Проверка победы
     * @param c
     * @return
     */
    private static boolean checkWin(char c){

        // Проверка по трем горизонталям
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        // Проверка по трем вертикалям
        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        // Проверка по диагоналям
        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;

        return false;
    }

    private static boolean checkWinV2(char c){


        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                if (field[x][y]==c && (check1(x,y) || check2(x,y) || check3(x,y) || check4(x,y))){
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Проверка по оси Х
     * @param x
     * @param y
     * @return
     */
    static boolean check1(int x, int y) {
        if (!(x+WIN_COUNT > fieldSizeX)) {
            int count = 0;
            while (count < WIN_COUNT-1) {

                if (field[x][y] == field[x + 1][y]) {
                    x++;
                    count++;
                } else return false;

            }
            return true;
        }else return false;
    }

    /**
     * Проверка по оси Y
     * @param x
     * @param y
     * @return
     */
    static boolean check2(int x, int y) {
        if (!(y+WIN_COUNT > fieldSizeY)) {
            int count = 0;
            while (count < WIN_COUNT-1) {

                if (field[x][y] == field[x][y+1]) {
                    y++;
                    count++;
                } else return false;
            }
            return true;
        }else return false;
    }

    /**
     * Проверка по диагонали вниз
     * @param x
     * @param y
     * @return
     */
    static boolean check3(int x, int y) {

        if ((y+WIN_COUNT<=fieldSizeY)&&(x+WIN_COUNT<=fieldSizeX)){
            int count = 0;
            while (count < WIN_COUNT-1) {

                if (field[x][y] == field[x+1][y+1]) {
                    x++;
                    y++;
                    count++;
                } else return false;
            }
            return true;
        }else return false;
    }

    /**
     * Проверка по диагонали вверх
     * @param x
     * @param y
     * @return
     */
    static boolean check4(int x, int y) {
        if (hasNext(x,y)){
            int count = 0;
            while (count < WIN_COUNT-1) {

                if (hasNext(x,y) && field[x][y] == field[x+1][y-1]) {
                    x++;
                    y--;
                    count++;
                } else return false;
            }return true;
        }return false;
    }
    static boolean hasNext(int x, int y){
        return x + 1 < fieldSizeX && y - 1 >= 0;
    }

    /**
     * Проверка на ничью
     * @return
     */
    private static boolean checkDraw(){
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

}
