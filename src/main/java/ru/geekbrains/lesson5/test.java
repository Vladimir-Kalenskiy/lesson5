package ru.geekbrains.lesson5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static String BACKUP_SUFFIX =".bak";

    public static void fileCopy(File srcFile, File destFile) throws Exception {
        InputStream src = new BufferedInputStream(new FileInputStream(srcFile));
        OutputStream dest = new BufferedOutputStream(new FileOutputStream(destFile));

        byte[] trans = new byte[1024];

        int count = -1;

        while ((count = src.read(trans)) != -1) {
            dest.write(trans, 0, count);
        }

        dest.flush();
        src.close();
        dest.close();
    }

    public static boolean backupTemplateFile(String templateFile) {
        boolean flag = true;

        File srcFile = new File(templateFile);
        if (!srcFile.exists()) {
            System.out.println("Файл шаблона не существует");
            return false;
        }

        // Создать файл резервной копии
        File backUpFile = new File(templateFile + BACKUP_SUFFIX);
        try {
            if (backUpFile.createNewFile()) {
                // Создать файл резервной копии успешно, скопировать файл
                fileCopy(srcFile, backUpFile);
            }
        } catch (Exception e) {
            flag = false;
            System.out.println("Ошибка резервного копирования файла");
        }

        return flag;
    }


//        static boolean searchMatch() throws IOException{
//        List<String> list = new ArrayList<>();
//        File dir = new File(".");
//        File[] files = dir.listFiles();
//        if (files == null)
//            return false;
//        for (int i = 0; i < files.length; i++){
//            if (files[i].isFile()){
//                fileCopy(files[i], new File(".\\backup"));
//            }
//
//
//        }
//        return true;
//    }

    }
