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

    
}
