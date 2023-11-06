package ru.geekbrains.lesson5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class HW5 {

    static void backUp() {

        File dir = new File(".");
        File[] files = dir.listFiles();
        assert files != null;
        List<File> lst = Arrays.stream(files).toList();
        for (int i = 0; i < lst.size(); i++)
            if (lst.get(i).isFile()) {
                Path output = Paths.get(lst.get(i).getName());
                Path backup = Paths.get("./backup/" + lst.get(i).getName());
                try {
                    Files.copy(output, backup);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        System.out.println("Backup complite.");
    }

}
