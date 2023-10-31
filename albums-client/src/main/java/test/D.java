package test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

public class D implements A,B{

    @Override
    public void function1() {

    }

//    @Override
//    public void defaultMethod() {
//        A.super.defaultMethod();
//    }

    @Override
    public void function2() {

    }

    {
        System.out.println("hahhahhaaha");
    }

    {
        System.out.println("fgfgfgfgfgfgfgfgfgf");
    }
    static {
        System.out.println("static block");
    }
    public static void main(String[] args) {
        D d = new D();
        d.defaultMethod();
    }
}