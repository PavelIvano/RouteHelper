package com.example.pavel2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileIOMain {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("C:\\Users\\Samsung_1\\AndroidStudioProjects\\Pavel2\\app\\src\\main\\java\\com\\example\\pavel2\\in.txt");
        Scanner scanner = new Scanner(f);
        try {
            String s = scanner.nextLine();
            System.out.println(s);
        } catch (NoSuchElementException e) {
            System.out.println("Файл есть но пустой");
        }
        PrintWriter writer = new PrintWriter(f);
        writer.print("467649");
        writer.flush();
    }
}
