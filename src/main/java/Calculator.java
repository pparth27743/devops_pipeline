//import java.util.Scanner;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//
//public class HelloWorld {
//
//
//
//    public static void  printAns(double ans){
//        System.out.println("************************************************");
//        System.out.println("Your answer is " + ans);
//        System.out.println("************************************************");
//    }
//
//
//    private static final Logger logger = LogManager.getLogger(Calculator.class);
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        int choice, num;
//        double ans;
//
//        do {
//
//            System.out.println("Welcome to Mini Calculator... \nChoose one of the Following operation.");
//            System.out.println("Press 1 for Square Root");
//            System.out.println("Press 2 for Factorial");
//            System.out.println("Press 3 for Natural logarithm");
//            System.out.println("Press 4 for Power function");
//            System.out.println("Press 0 to Exit");
//
//            choice = sc.nextInt();
//
//            switch (choice) {
//                case 1:
//                    System.out.println("Enter the Number");
//                    num = sc.nextInt();
//
//                    try{
//                        ans = Math.sqrt(num);
//                        printAns(ans);
//                    }catch (Exception e){
//                        System.out.println(e);
//                    }
//
//                    break;
//
//                case 2:
//                    System.out.println("Enter the Number");
//                    num = sc.nextInt();
//                    long sum = 1;
//                    for(int i=2; i<=num; i++) {
//                        sum = sum * i;
//                    }
//                    printAns(sum);
//                    break;
//
//                case 3:
//                    System.out.println("Enter the Number");
//                    num = sc.nextInt();
//
//                    try{
//                        ans = Math.log(num);
//                        printAns(ans);
//                    }catch (Exception e) {
//                        System.out.println(e);
//                    }
//                    break;
//
//                case 4:
//                    System.out.println("Enter the base number");
//                    num = sc.nextInt();
//                    System.out.println("Enter the power number");
//                    int power = sc.nextInt();
//
//                    try{
//                        ans = Math.pow(num, power);
//                        printAns(ans);
//                    }catch (Exception e) {
//                        System.out.println(e);
//                    }
//                    break;
//
//                case 0:
//                    break;
//
//                default:
//                    System.out.println("Please choose correct option");
//                    break;
//            }
//
//        }while(choice != 0);
//
//    }
//}
//


import java.util.Scanner;
import java.lang.Math;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {

    public double square_Root(double num)
    {
        double output = 0;
        try{
            logger.info("Calculating Square root  of number " + num);
            if(num < 0){
                output = Double.NaN;
                throw new ArithmeticException("Case of NaN squareRoot of < 0");
            }
            else{
                output = Math.sqrt(num);
            }
        }catch(ArithmeticException err){
            logger.error("Number cannot be negative " + err.getMessage());
        }finally {
            logger.info("Result of squareRoot is : " + output);
        }

        return output;
    }

    public double fact(double num)
    {
        double output = 1;
        try{
            if(num < 0) {
                output = Double.NaN;
                throw new ArithmeticException("Case of NaN factorial if < 0");
            }
            if(num!=(int)num)
            {
                output = Double.NaN;
                throw new ArithmeticException("Case of NaN factorial if num is not an integer");
            }

            if(num == 0 || num == 1) return 1;

            for(int i = 1; i <= num; i++){
                output *= i;
            }
        }
        catch(ArithmeticException err) {
            logger.error("Number cannot be negative " + err.getMessage());
        }
        finally {
            logger.info("Result of factorial is: " + output);
        }

        return output;
    }

    public double natural_Log(double num) {
        double output = 0;
        try{
            logger.info("Calculating Natural log of " + num);
            if(num <= 0){
                output = Double.NaN;
                throw new ArithmeticException("Case of NaN log of <= 0");
            }
            else{
                output = Math.log(num);
            }
        }
        catch(ArithmeticException err){
            logger.error("Number cannot be negative " + err.getMessage());
        }
        finally {
            logger.info("Result of naturalLog is : " + output);
        }
        return output;
    }

    public double power(double num1, double num2)
    {
        double output = 0;
        logger.info("Calculating Power  of two numbers " + num1 + " and " + num2);
        output = Math.pow(num1, num2);
        logger.info("Result of power is : " + output);
        return output;
    }

    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public static void main(String[] args) {
        double num1, num2;
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        char choice='y';
        do {


            System.out.print("Enter an operator \n 1. sqrt \n 2. factorial \n 3. log \n 4. power ");
            char operator = scanner.next().charAt(0);
            //scanner.close();
            double output=0.0;

            switch (operator) {
                case '1':
                    System.out.print("Enter first number:");
                    num1 = scanner.nextDouble();
                    try {
                        output = calculator.square_Root(num1)   ;
                    }catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;

                case '2':
                    System.out.print("Enter first number:");
                    num1 = scanner.nextDouble();
                    output = 1;
                    try {
                        output = calculator.fact(num1);
                    }catch (Exception e)
                    {
                        System.out.println(e);
                    }

                    //output = num1;
                    break;

                case '3':
                    System.out.print("Enter first number:");
                    num1 = scanner.nextDouble();
                    try {
                        output = calculator.natural_Log(num1);
                    }catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;

                case '4':
                    System.out.print("Enter first number:");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter second number:");
                    num2 = scanner.nextDouble();
                    try {
                        output = Math.pow(num1, num2);
                    }catch(Exception e)
                    {
                        System.out.println(e);
                    }

                    break;

                default:
                    System.out.printf("You have entered wrong operator");
                    return;
            }

            System.out.println("Output: " + output);
            System.out.println("Press y to continue");
            choice = scanner.next().charAt(0);
        }while(choice=='y');
        scanner.close();
    }
}
