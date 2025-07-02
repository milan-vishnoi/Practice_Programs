package miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class StackMonotonicStack {

    public static boolean isValid(String s) {
       char[] stack = new char[s.length()];
       Map<Character,Character> pair = new HashMap<>();
       pair.put(')','(');
       pair.put('}','{');
       pair.put(']','[');
        int top=-1;
        for(char ch:s.toCharArray())
        {
            if(ch=='('||ch=='{'||ch=='[')
            {
                stack[++top]=ch;
            }
            else
            {
                if(top==-1)
                return false;
                if(pair.get(ch)==stack[top])
                top--;
                else
                return false;
            }
        }
        if(top==-1)
        return true;
        else
        return false;
        
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
    
}
