package ru.geekbrains.lesson5;

import java.io.File;

public class Tree {

    public static void main(String[] args) {

        print(new File("."), "", true);

    }

    /**
     * TODO: Доработать метод print, необходимо распечатывать директории и файлы
     * @param file
     * @param indent
     * @param isLast
     */
    public static void print(File file, String indent, boolean isLast){
        System.out.print(indent);
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else{
            System.out.print("├─");
            indent += "│ ";
        }
        /**
         * добавил проверку на файл и вывод имени файла
         */
        if (file.isFile()) {
            System.out.println(file.getName());
        }else if (file.isDirectory()) {
            System.out.println(file.getName());

            File[] files = file.listFiles();
            if (files == null)
                return;

            int subDirTotal = 0;
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory())
                    subDirTotal++;
            }

            int subDirCounter = 0;
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    subDirCounter++;
                    print(files[i], indent, subDirCounter == subDirTotal);
                }else if (files[i].isFile()) //добавил рекурсию, если это файл
                {
                    print(files[i], indent, i+1 == files.length);
                }

            }
        }
    }

}
