package runLengthEncodeDecode;

import org.junit.Test;
import org.junit.Assert;

public class RunLengthEncoderDecoderTest {
    
    RunLengthEncoderDecoder encoderDecoder = new RunLengthEncoderDecoder();

    @Test
    public void simpleEncoder()
    {
        String str = "WWWMMMKKK";
        Assert.assertEquals("W3M3K3",encoderDecoder.encode(str));
    }

    @Test
    public void encodeStringWithUniqueCharacters()
    {
        String str = "WMK";
        Assert.assertEquals("W1M1K1", encoderDecoder.encode(str));
    }

    @Test
    public void encodeSingleCharacterString()
    {
        String str = "W";
        Assert.assertEquals("W1", encoderDecoder.encode(str));
    }

    @Test
    public void encodeLongString()
    {
        String str = "WWWWWWWWWWWWWWWWWWWWWWWWWWMMMMMMMMMMMMMMMMMMMMMMMKKKKKKKKKKKKKKKKKKKKWWW";
        Assert.assertEquals("W26M23K20W3", encoderDecoder.encode(str));
    }

    @Test
    public void simpleDecoder()
    {
        String str = "W3M3K3";
        Assert.assertEquals("WWWMMMKKK",encoderDecoder.decode(str));
    }

    @Test
    public void decodeStringWithUniqueCharacters()
    {
        String str = "W1M1K1";
        Assert.assertEquals("WMK", encoderDecoder.decode(str));
    }

    @Test
    public void decodeMorethan10Characters()
    {
        String str = "W12M12N3";
        Assert.assertEquals("WWWWWWWWWWWWMMMMMMMMMMMMNNN", encoderDecoder.decode(str));
    }
    @Test
    public void decodeMorethan100Characters()
    {
        String str = "W101M12N3";
        Assert.assertEquals("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW"+
        "MMMMMMMMMMMMNNN", encoderDecoder.decode(str));
    }

    @Test
    public void testEncoding()
    {
        char mode = 'E';
        String str = "WWWWWWWWWWWWWWWWWWWWWWWWWWMMMMMMMMMMMMMMMMMMMMMMMKKKKKKKKKKKKKKKKKKKKWWW";
        Assert.assertEquals("W26M23K20W3", encoderDecoder.encoderDecoder(mode, str));
    }


    
}
