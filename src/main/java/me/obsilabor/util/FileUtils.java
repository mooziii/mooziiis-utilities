package me.obsilabor.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtils {

    public static void writeToFile(File file, String string) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(string);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(File file) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            Files.lines(file.toPath()).forEach(stringBuilder::append);
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "Exception during read proccess";
        }
    }

}