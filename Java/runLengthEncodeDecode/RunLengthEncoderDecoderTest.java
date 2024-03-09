package runLengthEncodeDecode;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class RunLengthEncoderDecoderTest {
    
    RunLengthEncoderDecoder encoderDecoder = new RunLengthEncoderDecoder();

    @Test
    public void simpleEncoder()
    {
        char mode = 'E';
        String str = "WWWMMMKKK";
        Assert.assertEquals("W3M3K3",encoderDecoder.encode(str));
    }

    @Test
    public void encodeStringWithUniqueCharacters()
    {
        char mode = 'E';
        String str = "WMK";
        Assert.assertEquals("W1M1K1", encoderDecoder.encode(str));
    }
}
