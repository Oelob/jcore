package ru.geekbrains.lesson5;

import java.io.*;

public class Backup {

    public static void main(String[] args) throws IOException {

        backupDir(PATH);

    }
    private static final String PATH = "C:\\Users\\1\\IdeaProjects\\homeworks\\homework_5\\test_backup";
    private static String sub_path = "";

    public static void getParent(String dir) throws IOException {
        File homedir = new File(dir);

        System.out.println(homedir.getParent());

    }

    /**
     * Метод определения адреса текущей папки относительно начальной
     * Возвращает результат в виде subdir\sub2dir\
     * @param dir
     * @return
     */
    public static String dir_path(String dir){
        String res = "";
        File homedir = new File(dir);
        if (homedir.getParent().equals(PATH)) {
            res = homedir.getName() + "\\";
        }else if (homedir.getAbsolutePath().equals(PATH)){
            res = "";
        }else{
            File temp = homedir.getParentFile();
            res += temp.getName() + "\\" + homedir.getName() + "\\";
            dir_path(temp.getAbsolutePath());
        }
        return res;
    }

    /**
     * Метод копирования файлов
     * @param file  - входиящий файл
     * @param fileOut - исходящий файл (копия)
     * @throws IOException
     */
    public static void backup(File file, String fileOut) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileOut)){

            int c;
            try(FileInputStream fileInputStream = new FileInputStream(file)){
                while ( (c = fileInputStream.read()) != -1)
                    fileOutputStream.write(c);
            }
        }
    }

    /**
     * Метод создания резервной копии папки
     * @param dir - путь к папке, копию которой необходимо создать
     * @throws IOException
     */
    public static void backupDir(String dir) throws IOException {
        File homedir = new File(dir);

        // просмотр папки, которую нужно копировать
        File[] files = homedir.listFiles();
        if (files == null)
            return;

        // создаю папки для копирования файлов

        new File(PATH+"\\backup\\").mkdir();

        // копирование файлов
        for (int i = 0; i < files.length; i++){

            if (files[i].isDirectory()){
                sub_path += files[i].getName() + "\\";
                new File(PATH+"\\backup\\"+ sub_path).mkdir();
                backupDir(files[i].getAbsolutePath());
            } else if (files[i].isFile()) {
                if (dir_path(homedir.getAbsolutePath()).isEmpty()){
                backup(files[i], PATH + "\\backup\\" + files[i].getName());
                }else{
                    backup(files[i], PATH + "\\backup\\" + dir_path(homedir.getAbsolutePath()) + files[i].getName());
                }
            }
        }
    }
}
