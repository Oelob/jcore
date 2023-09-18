package ru.geekbrains.lesson4.task_homework;

public class Program {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        String[][] example = {{"2","4","5","1"},
                              {"5","4","6","4"},
                              {"4","7","?","5"},
                              {"3","5","4","5"}};

        System.out.println(sum(example));

    }

    /**
     * Метод проверки двумерного массива 4х4 и суммирования его элементов
     * @param array - принимаемый двумерный массив
     * @return
     * @throws MyArraySizeException - исключение, возникающее при недопустимом размере массива
     * @throws MyArrayDataException - исключение, возникающее при недопустимом значении в массиве
     */
    public static int sum (String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {throw new MyArraySizeException("Неверный размер массива!");}
        int result = 0;
        for (int i = 0; i< array.length; i++){
            for (int g = 0; g < array[0].length; g++) {
                try {
                    int temp = Integer.parseInt(array[i][g]);
                    result = result + temp;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("В ячейке array[%d][%d] неверный символ", i,g));
                }
            }
        }
        return result;
    }
}
