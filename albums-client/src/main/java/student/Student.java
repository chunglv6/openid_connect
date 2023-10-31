package student;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Student implements Runnable{

    private int id;
    private Book[] books;
    private Random random;
    private Set<Integer> readBooks;

    public Student(int id, Book[] books) {
        this.id = id;
        this.books = books;
        this.random = new Random();
        readBooks = new HashSet<>();
    }

    @Override
    public void run() {
        while (readBooks.size() != books.length){
            int bookId = random.nextInt(Constant.NUM_OF_BOOKS);
            try {
                if(!readBooks.contains(bookId)){
                    books[bookId].read(this);
                    readBooks.add(bookId);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Student" +id;
    }
}
