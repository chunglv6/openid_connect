package test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


//ZipUtil
public class ZipUtil {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please, enter height of rectangle: ");
        int height = sc.nextInt();
        System.out.print("Please, enter width of rectangle: ");
        int width = sc.nextInt();

        drawRectangle(height, width);

    }

    public static void drawRectangle(int height, int width) {
        for(int i = 0;i<height;i++){
            for(int j=0;j<width;j++){
                if(i == 0 || i== height -1){
                    System.out.print("*");
                }else {
                    if(j ==0 || j == width -1){
                        System.out.print("*");
                    }else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println("\n");
        }
    }

}