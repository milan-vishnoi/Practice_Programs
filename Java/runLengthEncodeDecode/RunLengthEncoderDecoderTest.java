package runLengthEncodeDecode;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class RunLengthEncoderDecoderTest {
    
    RunLengthEncoderDecoder encoderDecoder = new RunLengthEncoderDecoder();

    @Before
    public void initialize()
    {
        
    }

    @Test
    public void encoderTest()
    {
        char mode = 'E';
        String str = "WWWMMMKKK";
        Assert.assertEquals(encoderDecoder.encoder(str),"W3M3K3");
    }
}
