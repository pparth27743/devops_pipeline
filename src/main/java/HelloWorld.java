import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {

        System.out.println("Hello World !!!");
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a= sc.nextInt();
        System.out.print("Enter second number: ");
        int b= sc.nextInt();
        int d=a+b;
        System.out.println("Addition of 2 numbers : " + d);

    }

}
