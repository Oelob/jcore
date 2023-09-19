package ru.geekbrains.lesson5;

import java.io.*;

public class Backup {

    public static void main(String[] args) throws IOException {
//        backup("C:\\Users\\1\\IdeaProjects\\homeworks\\homework_5\\test_backup\\unnamed.jpg",
//                "C:\\Users\\1\\IdeaProjects\\homeworks\\homework_5\\test_backup\\copyfile.jpg");

        backupDir(PATH);
    }
    private static final String PATH = "C:\\Users\\1\\IdeaProjects\\homeworks\\homework_5\\test_backup\\";
    private static boolean isExist = false;
    public static void backup(File file, String fileOut) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileOut)){

            int c;
            try(FileInputStream fileInputStream = new FileInputStream(file)){
                while ( (c = fileInputStream.read()) != -1)
                    fileOutputStream.write(c);
            }
        }
    }

    public static void backupDir(String dir) throws IOException {
        File homedir = new File(dir);

        // просмотр папки, которую нужно копировать
        File[] files = homedir.listFiles();
        if (files == null)
            return;

        // создаю папку для копирования файлов


        new File(PATH+"\\backup\\").mkdir();
        new File(PATH+"\\backup\\" + homedir.getName() + "\\").mkdir();

        // копирование файлов
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory()){
                new File(PATH+"\\backup\\"+ files[i].getName() + "\\").mkdir();
                backupDir(files[i].getAbsolutePath());
            } else if (files[i].isFile())
            backup(files[i], PATH+"\\backup\\" + homedir.getName() + "\\" + files[i].getName());
        }
    }
}
