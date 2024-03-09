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
        return encoder(str);
        else if(mode == 'D')
        return decoder(str);
        else
        return "";
    }

    public String encoder(String str)
    {
       // char alphabet[] = new char[str.length()];
        //int count[] = new int [str.length()];
        String result="";
        for(int i = 0; i<str.length(); i++)
        {  
            int k;
            result+=str.charAt(i);
           for(k=0;str.charAt(i)==str.charAt(i+1);k++,i++)
           {

           }
           result+=k;
        }

        return result;
    }

    public String decoder(String str)
    {
        return "";
    }

}
    

