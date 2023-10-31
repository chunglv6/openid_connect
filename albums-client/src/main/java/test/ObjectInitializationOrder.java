package test;

public class ObjectInitializationOrder {

    public static void main(String[] args) {
        ParentClass p = new Child();
        System.out.println("=====================");
        p = new Child();
    }

}


class Parent {
    static {
        System.out.println("Static init block parent");
    }

    {
        System.out.println("Init block parent");
    }

    public Parent() {
        System.out.println("Parent constructor");
    }

}

class Child extends ParentClass {
    static {
        System.out.println("Static init block child");
    }

    {
        System.out.println("Init block child");
    }

    public Child() {
        System.out.println("child constructor");
    }
}
