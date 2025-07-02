package miscellaneous;

public class StackMonotonicStack {

    public static boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top=-1;
        for(char ch:s.toCharArray())
        {  System.out.println(ch);
            if(ch=='('||ch=='{'||ch=='[')
            {
                stack[++top]=ch;
            }
            else 
            {
                if(top==-1)
                return false;
                if(ch==')')
                {
                    if(stack[top]=='(')
                    top--;
                    else
                    return false;
                }
                else if(ch=='}')
                {
                    if(stack[top]=='{')
                    top--;
                    else
                    return false;
                }
                else if(ch==']')
                {
                    if(stack[top]=='[')
                    top--;
                    else
                    return false;
                }
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
