package advancedproblems;

public class Recursion {
    public static int factorial(int num)
    {
        if(num<=1)
        return 1;

        return num*factorial(num-1);
    }

    public static void printAscending(int num)
    {
       if(num==1)
       {
        System.out.print(num+" ");
        return;
       }

        printAscending(num-1);
        System.out.print(num+" ");

    }

    public static void printDescending(int num)
    {
       if(num==1)
       {
        System.out.print(num+" ");
        return;
       }

        System.out.print(num+" ");
        printDescending(num-1);

    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
        printAscending(5);
        System.out.println();
        printDescending(5);

    }
}
