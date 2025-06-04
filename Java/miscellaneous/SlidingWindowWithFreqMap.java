package miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlidingWindowWithFreqMap {

    // Problem : https://leetcode.com/problems/find-all-anagrams-in-a-string/
    public static List<Integer> findAnagrams(String s, String p) {

       List<Integer> anagrams = new ArrayList<>();
       if( s==null || p==null || s.isEmpty()||p.isEmpty()||s.length()<p.length())
        return anagrams;

       int[] frequencyMap = new int[26];
       int[] currentFrequency = new int[26];
       int start=0;
       int validValue = 0;
       int currentChar;
       int sChar;

       for(Character ch:p.toCharArray())
        frequencyMap[ch-97]++;

       for(int end=0; end<s.length(); end++)
       {
        currentChar = s.charAt(end)-97;
        if(frequencyMap[currentChar]!=0)
        {
            currentFrequency[currentChar]++;
            if(currentFrequency[currentChar] <= frequencyMap[currentChar])
                validValue++;   //Valid value only if current freq is less than or equal to in anagram string

            sChar = s.charAt(start) - 97;

            if(end-start+1 == p.length())
            {

               if(validValue == p.length())
                anagrams.add(start);  // Add the index to array if we have valid values equal to anagram string length
            
               if(currentFrequency[sChar] <= frequencyMap[sChar])
                validValue--;      //Reduce validValue count only if we are removing a valid entry.
                                  // for "abc" if a has 2 then it was invalid value so we won't reduce in such case

               currentFrequency[sChar]--;
               start++;
            } 
    }
     else
        {
            Arrays.fill(currentFrequency,0); // Resetting the current freqeuncy map
            validValue=0;
            start=end+1;
        }

       }

       return anagrams;
}

    public static void main(String[] args) {
           
        SlidingWindowWithFreqMap.findAnagrams("abcbasc", "abc");

        
    }
    
}
