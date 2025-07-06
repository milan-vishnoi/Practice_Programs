package miscellaneous;

import java.util.Arrays;

public class StackMonotonicStack {

    // Leetcode Problem https://leetcode.com/problems/valid-parentheses/
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

    //Leetcode Problem https://leetcode.com/problems/next-greater-element-i/
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int mapping[] = new int[10001];
        int[] stack = new int[nums2.length];
        int result[] = new int[nums1.length]; 

        int top=0;
        stack[top] = nums2[0];
        for(int i=1;i<nums2.length;i++)
        {
            while(top>=0&&nums2[i]>stack[top])
            mapping[stack[top--]]=nums2[i];

            stack[++top] = nums2[i];
        }
        for(int i=0;i<nums1.length;i++)
        {
            if(mapping[nums1[i]]>0)
            result[i] = mapping[nums1[i]];
            else
            result[i] = -1;

        }

        return result;
    }

    //Leetcode Problem https://leetcode.com/problems/next-greater-element-ii/
    public static int[] nextGreaterElementsCircularArray(int[] nums) {
        int stack[] = new int[2*nums.length];
        int result[] = new int[nums.length];
        Arrays.fill(result,-1);
        int top=0;
        stack[top] = 0;
        int currentIndex;
        for(int i=1;i<2*nums.length-1;i++)
        {
            currentIndex = i%nums.length;
            while(top>=0&&nums[currentIndex]>nums[stack[top]])
            result[stack[top--]] = nums[currentIndex];

            stack[++top] = currentIndex;
        }
        
        return result;
    }

    // Leetcode Problem https://leetcode.com/problems/daily-temperatures/
    public static int[] dailyTemperatures(int[] temperatures) {
        int stack[] = new int[temperatures.length];
        int answer[] = new int[temperatures.length];
    
        int top = 0;
        stack[top] = 0;
        for(int i=1;i<temperatures.length;i++)
        {
            while(top>=0&&temperatures[i]>temperatures[stack[top]])
             answer[stack[top]] = i - stack[top--];

             stack[++top] = i;
        }
        return answer;
    }

    // Leetcode Problem https://leetcode.com/problems/largest-rectangle-in-histogram/
    public static int largestRectangleArea(int[] heights) {

        if(heights.length==0)
        return 0;
        int stack[] = new int[heights.length+1];
        int result=heights[0], h;
        int top=-1;
        int width, height;
        if(heights.length==1)
        return result;

        for(int i=0; i<=heights.length;i++)
        {
            h = (i==heights.length)?0:heights[i];
           
            while(top>=0&&h<heights[stack[top]])
            {
                height = heights[stack[top--]];
                width = (top==-1)?i:i-stack[top]-1;
                result = Math.max(result,height*width);
            }
            stack[++top] = i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
    
}
