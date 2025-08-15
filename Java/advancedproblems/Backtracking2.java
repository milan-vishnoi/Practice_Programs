package advancedproblems;

import java.util.ArrayList;
import java.util.List;

public class Backtracking2 {

    static Backtracking2 backtracking2 = new Backtracking2();

    //Leetcode problem https://leetcode.com/problems/letter-combinations-of-a-phone-number/
    public static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if("".equals(digits))
        return result;

        String[] mappings = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        backtracking2.findCombination(0,digits,mappings,new StringBuilder(),result);

        return result;

    }

    private void findCombination(int i,String digits,String[] mappings,StringBuilder combo,List<String> result)
    {
        if(i==digits.length())
        {
            result.add(combo.toString());
            return;
        }

        int digit = digits.charAt(i)-'0';

        for(int index=0;index<mappings[digit].length();index++)
        {
            combo.append(mappings[digit].charAt(index));
            findCombination(i+1,digits,mappings,combo,result);
            combo.deleteCharAt(combo.length()-1);
        }

    }

    //Leetcode Problem https://leetcode.com/problems/palindrome-partitioning/
    public static List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        backtracking2.findPartition(0, s, new ArrayList<>(), result);

        return result;

    }

    private void findPartition(int i, String s, List<String> partition, List<List<String>> result) {
        if (i == s.length()) {
            result.add(new ArrayList<>(partition));
            return;
        }

        //String str;

        for (int index = i; index < s.length(); index++) {
            String str = s.substring(i, index + 1);

            if (isPalindrom(str)) {
                partition.add(str);
                findPartition(index + 1, s, partition, result);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private boolean isPalindrom(String sb) {
        if (sb.length() <= 1)
            return true;

        for (int i = 0, j = sb.length() - 1; i < j; i++, j--) {
            if (sb.charAt(i) != sb.charAt(j))
                return false;
        }

        return true;
    }

    //Leetcode Problem https://leetcode.com/problems/restore-ip-addresses/
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s.length()>12)
        return result;

      backtracking2.findIp(0,s,new StringBuilder(),0,result);

        return result; 
        
    }

    private void findIp(int i,String s, StringBuilder ip,int sCount, List<String> result)
    {
        int length = s.length();
        if(i==length)
        {
            if(sCount==4)
            result.add(ip.toString());

            return;
        }

      String segment;
      int sbLength = ip.length();

        for(int j=1;j<=3;j++)
        {
        if(i+j>length)
        return;
        int remainingChars = s.length() - (i + j);
        int remainingSegments = 4 - (sCount + 1);
        if (remainingChars < remainingSegments || remainingChars > remainingSegments * 3) 
        continue;
        segment = s.substring(i,i+j);
        if(isValid(segment))
        {
            if(sCount>0)
            ip.append(".");
            ip.append(segment);
            findIp(i+j,s,ip,sCount+1,result);
           ip.setLength(sbLength);
        }
        else
        return;
        }
    }

    private boolean isValid(String s)
    {
    if (s.length() > 1 && s.startsWith("0")) 
    return false;
    int val = Integer.parseInt(s);
    return val >= 0 && val <= 255;
    }

    //Leetcode Problem https://leetcode.com/problems/n-queens/
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2*n];
        boolean[] diag2 = new boolean[2*n];

        backtracking2.findNQueen(0,n,cols,diag1,diag2,new ArrayList<>(),result);

        return result;
        
    }

    private void findNQueen(int i, int n,boolean[] cols, boolean[] diag1, boolean[] diag2, List<String> combo, List<List<String>> result)
    {
        if(i==n)
        {
            result.add(new ArrayList<>(combo));
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int index=0;index<n;index++)
        sb.append('.');

        for(int j=0;j<n;j++)
        {
            int d1 = n+ i-j;
            int d2 = i+j;
            if(!cols[j] && !diag1[d1] && !diag2[d2])
            {
               sb.setCharAt(j,'Q');
               cols[j] = true;
               diag1[d1] = true;
               diag2[d2] = true;
               combo.add(sb.toString());
               findNQueen(i+1,n,cols,diag1,diag2,combo,result);
               cols[j] = false;
               diag1[d1] = false;
               diag2[d2] = false;
               sb.setCharAt(j,'.');
               combo.remove(combo.size()-1);
            }
        }

    }

    //Leetcode Problem https://leetcode.com/problems/expression-add-operators/
    public static List<String> addOperators(String num, int target) 
    {
        List<String> result = new ArrayList<>();
        
        backtracking2.findExpression(0,num,target,0,0,"",result);

        return result;
        
    }

    private void findExpression(int index,String num,int target, long eval, long prev, String path, List<String> result)
    {

    if(index==num.length())
        {
          if(eval==target)
            result.add(path);

            return;
        }
    
       String currStr;
       long currNum;
       for(int i=index;i<num.length();i++)  //for generating digits with multiple numbers
       {
        if(i!=index && num.charAt(index)=='0')  // if there arev more than 1 digit and leading is 0 the skip that path
        break;
        currStr = num.substring(index,i+1);
        currNum = Long.parseLong(currStr);

         if(index==0)
         findExpression(i+1,num,target,currNum,currNum,currStr,result); // for 0th index there won't be any operator
         else
         {
            // for addition
            findExpression(i+1,num,target,eval+currNum,currNum,path+'+'+currStr,result);

            //for subtractiom
            findExpression(i+1,num,target,eval-currNum,-currNum,path+'-'+currStr,result);

            //for multiplication
            findExpression(i+1,num,target,(eval-prev)+(prev*currNum),prev*currNum,path+'*'+currStr,result);
         }
       }
  
    }

    
}
