package ru.geekbrains.lesson5;

import java.io.*;

public class Backup {

    public static void main(String[] args) throws IOException {
//        backup("C:\\Users\\1\\IdeaProjects\\homeworks\\homework_5\\test_backup\\unnamed.jpg",
//                "C:\\Users\\1\\IdeaProjects\\homeworks\\homework_5\\test_backup\\copyfile.jpg");

        backupDir("C:\\Users\\1\\IdeaProjects\\homeworks\\homework_5\\test_backup\\");
    }
    private static final String PATH = "C:\\Users\\1\\IdeaProjects\\homeworks\\test_backup\\text.txt";
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

        // создаю папку для копирования файлов

        if (!isExist){
        new File(dir+"\\backup\\").mkdir();
        isExist = true;
        }

        // просмотр папки, которую нужно копировать
        File[] files = homedir.listFiles();
        if (files == null)
            return;

        // копирование файлов
        for (int i = 1; i < files.length; i++){
            if (files[i].isDirectory()){
                continue;
            }
            backup(files[i], dir + "\\backup\\" + files[i].getName());
        }



    }
}
