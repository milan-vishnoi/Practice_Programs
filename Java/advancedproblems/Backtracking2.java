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
    
}
