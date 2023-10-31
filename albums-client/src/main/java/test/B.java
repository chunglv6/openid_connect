package test;

public interface B{
    void function2();
    default void defaultMethod(){
        System.out.println("this is the another default method");
    }
}
