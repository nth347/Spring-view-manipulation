package com.nth347.springviewmanipulation;

import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        String out = new Scanner(Runtime.getRuntime().exec("id").getInputStream()).next();
        System.out.println(out);
    }
}
