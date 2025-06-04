package miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlidingWindowWithFreqMap {

    // Problem : https://leetcode.com/problems/find-all-anagrams-in-a-string/
    public static List<Integer> findAnagrams(String s, String p) {

       List<Integer> anagrams = new ArrayList<>();
       if( s==null || p==null || s.isEmpty()||p.isEmpty()||s.length()<p.length())
        return anagrams;
       Map<Character,Integer> frequencyMap = new HashMap<>();
       Map<Character,Integer> currentFrequency = new HashMap<>();
       int start=0;
       int count = 0;
       char currentChar;
       for(Character ch:p.toCharArray())
       frequencyMap.put(ch,frequencyMap.getOrDefault(ch,0)+1);

       for(int end=0; end<s.length(); end++)
       {
        currentChar = s.charAt(end);
        if(frequencyMap.containsKey(currentChar)){
            currentFrequency.put(currentChar,currentFrequency.getOrDefault(currentChar,0)+1);
            if(currentFrequency.get(currentChar) <= frequencyMap.get(currentChar)) {
                count++;
            }
        char sChar = s.charAt(start);

        if(end-start+1 == p.length())
        {
        if(count == p.length())
        {
            anagrams.add(start);

        }
            
            if(currentFrequency.get(sChar).intValue() <= frequencyMap.get(sChar).intValue()) {
                count--;
            }
         
            currentFrequency.put(sChar,currentFrequency.get(sChar)-1);
            if(currentFrequency.get(sChar)==0)
            currentFrequency.remove(sChar);

            start++;
        }
        } else
        {
            currentFrequency.clear();
            count=0;
            start=end+1;
        }
       // System.out.println(count);

       }

       return anagrams;
}

    public static void main(String[] args) {
        
    }
    
}
