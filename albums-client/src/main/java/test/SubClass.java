package test;

public class SubClass extends ParentClass{

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        System.out.println(subClass.DEBUG);
    }

    public static final boolean DEBUG = false;
    public void method(){
        while(Boolean.FALSE){
            System.out.println("debug statement here");
        }
    }
}
