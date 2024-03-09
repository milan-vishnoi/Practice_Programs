package runLengthEncodeDecode;

import static org.junit.Assert.assertArrayEquals;

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

    public String decoder(String str)
    {
        return "";
    }

}
    

