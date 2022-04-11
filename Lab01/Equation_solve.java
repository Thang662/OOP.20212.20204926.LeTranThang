import java.util.Scanner;

public class Equation_solve{
    
    // Linear equation ax + b = 0
    public static void LinearEqua(double a, double b){
        System.out.println("x= " + (-b/a));
    }
    public static boolean checkLinear(double a){
        if (a != 0){
            return true;
        }
        return false;
    }

    // Linear system
    public static double computeD(double a11, double a12, double a21, double a22){
        return a11*a22 - a21*a12;
    }

    public static void linearSystem(double a11, double a12, double b1, double a21, double a22, double b2){
        System.out.println("x1 =" + ((b1*a22 - b2 * a12)/(a11*a22 - a12 *a21)));
        System.out.println("x2 =" + ((b1*a21 - b2 * a11)/(a12 *a21 - a22 *a11)));
    }

    // Second order Equation

    public static double computeDelta(double a, double b, double c){
        return Math.pow(b, 2) - 4 * a * c; 
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Linear Equation");
        System.out.println("2 - Linear System");
        System.out.println("3 - Second order Equation");
        System.out.println("What type of equation you want to sole? ");
        int input = sc.nextInt();
        if (input == 1){
            System.out.print("Input a =");
            int a = sc.nextInt();
            System.out.print("Input b =");
            int b = sc.nextInt();
            if (checkLinear(a)){
                LinearEqua(a, b);
            }
            else {
                System.out.println("a = 0");
            }
        }
        else if (input == 2){
            System.out.print("Input a11 =");
            double a11 = sc.nextDouble();
            System.out.print("Input a12 =");
            double a12 = sc.nextDouble();
            System.out.print("Input b1 =");
            double b1 = sc.nextDouble();
            System.out.print("Input a21 =");
            double a21 = sc.nextDouble();
            System.out.print("Input a22 =");
            double a22 = sc.nextDouble();
            System.out.print("Input b2 =");
            double b2 = sc.nextDouble();
            if ( computeD(a11, a12, a21, a22) == 0){
                System.out.println("This system has no solution or infinite solution");
            }
            else {
                linearSystem(a11, a12, b1, a21, a22, b2);
            }
        }
        else {
            System.out.print("Input a =");
            double a = sc.nextDouble();
            System.out.print("Input b =");
            double b = sc.nextDouble();
            System.out.print("Input c =");
            double c = sc.nextDouble();
            if (computeDelta(a, b, c) < 0){
                System.out.println("This equation has no solution");
            }
            else if (computeDelta(a, b, c) == 0){
                System.out.println("This equation has unique solution x=" + (-b/2/a));
            }
            else {
                System.out.println("x1 = "+ (-b + Math.sqrt(computeDelta(a, b, c))/(2*a)));
                System.out.println("x2 = "+ (-b - Math.sqrt(computeDelta(a, b, c))/(2*a)));
            }
        }
    }


}