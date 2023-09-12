package ru.geekbrains.lesson4.task_homework;

public class Program {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        String[][] example = {{"2","4","5","1"},
                              {"5","4","6","4"},
                              {"4","?","4","5"},
                              {"3","5","4","5"}};

        System.out.println(sum(example));

    }

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
