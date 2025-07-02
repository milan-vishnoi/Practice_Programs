package miscellaneous;

public class StackMonotonicStack {

    public static boolean isValid(String s) {
       char[] stack = new char[s.length()];
        int top=-1;
        for(char ch:s.toCharArray())
        {
            if(ch=='(')
            {
               stack[++top] = ')';
            }
            else if(ch=='{')
            {
               stack[++top] = '}';
            }
            else if(ch=='[')
            {
                 stack[++top] = ']';
            }
            else
            {
                if(top==-1 || ch!=stack[top])
                return false;
                top--;
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
