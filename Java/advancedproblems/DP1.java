package advancedproblems;

public class DP1 {

    //Leetcode Problem https://leetcode.com/problems/fibonacci-number/
    public static int fib(int n) {
     
     if(n<0)
     throw new IllegalArgumentException();
     if(n==0||n==1)
     return n;

     int prev1=0;
     int prev2 =1;
     int current=1;
     

     for(int i=2;i<=n;i++)
     {
        prev2 = prev1;
        prev1 = current;
        current = prev1 + prev2;
     }

     return current;
        
    }   
    
}
