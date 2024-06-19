package com.example.pavel2;

public class ExceptMain {
    public static void main(String[] args) throws Exception {
        Object o = new Object();
        System.out.println("Hello world");
        try  {
            System.out.println(o.toString());
            System.out.println(1/0);
        } catch (NullPointerException e ) {
            System.out.println("Произошла ошибка");
        } catch (ArithmeticException e2) {
            System.out.println("Кто учил тебя делить на 0");
        }
        System.out.println("The end");
        setDenominator(5);
    }

    public static void setDenominator(int denominator) throws Exception {
         Exception e = new Exception("Неправельный знаменатель");
            throw e;
    }
}