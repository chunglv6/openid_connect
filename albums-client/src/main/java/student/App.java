package student;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {
        Student[] students = null;
        Book[] books = null;
        ExecutorService es = Executors.newFixedThreadPool(Constant.NUM_OF_STUDENTS);
        try {
            books = new Book[Constant.NUM_OF_BOOKS];
            students = new Student[Constant.NUM_OF_STUDENTS];
            for (int i=0;i<Constant.NUM_OF_BOOKS;i++){
                books[i] = new Book(i+1);
            }
            for (int i=0;i<Constant.NUM_OF_STUDENTS;i++){
                students[i] = new Student(i+1,books);
                es.execute(students[i]);
            }

        } catch (Exception e){
            e.printStackTrace();
        }finally {
            es.shutdown();
        }
    }
}
