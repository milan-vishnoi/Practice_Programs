package runLengthEncodeDecode;

public class RunLengthEncoderDecoder
{
   
    public static void main(String args[])
    {
        System.out.println("Milan");
        int count[] = new int [5];
        System.out.println(count[3]);
    }

    public String encoderDecoder(char mode,String str)
    {
        if(mode == 'E')
        return encode(str);
        else if(mode == 'D')
        return decode(str);
        else
        return "";
    }

    public String encode(String str)
    {
        String result="";
        result+= str.charAt(0);
        int k = 1;
        for(int i = 1; i<str.length(); i++)
        {  
            if(str.charAt(i)==str.charAt(i-1))
            k++;
            else
            {
               result+= k;
               k = 1;
               result+= str.charAt(i);

            }

        }
        result += k;

        return result;
    }

    public String decode(String str)
    {
        String result = "";
        char alphabet = 0;
        int size =0 ;
        for(int i= 0; i<str.length();i++)
        {   
           
           if(Character.isAlphabetic(str.charAt(i)))
           {
            alphabet = str.charAt(i);
            size = 0;
           }
           else if(Character.isDigit(str.charAt(i)))
           {
            size = size*10 + Character.getNumericValue(str.charAt(i));
            if(i == str.length()-1 || Character.isAlphabetic(str.charAt(i+1)))
            {
                for(int j=1;j <= size;j++)
                {
                  result+=alphabet;
                }
            }
            
           }
            
        }
        
        return result;
        
    }

}
    

