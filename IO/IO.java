package IO;

import java.util.Scanner;
public class IO {
    static void inputArrayOfInt(){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i]= s.nextInt();
        }

        System.out.print("The array include: ");
        for(int i : array)
            System.out.print(i + " ");
        System.out.println();
    }
    static void inputArrayOfStringBySpace(){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String[] array = new String[n];
        for(int i=0;i<n;i++){
            array[i]= s.next();
        }
        System.out.print("The array include: ");
        for(String i : array)
            System.out.print(i + " ");
        System.out.println();
    }

    static void inputArrayOfStringByLine(){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.skip(System.lineSeparator());
        String[] array = new String[n];
        for(int i=0;i<n;i++){
            array[i]= s.nextLine();
        }
        
        System.out.print("The array include: ");
        for(String i : array)
            System.out.print(i + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        inputArrayOfStringByLine();
    }
}
