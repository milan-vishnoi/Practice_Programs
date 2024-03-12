package runLengthEncodeDecode;

import org.junit.Test;
import org.junit.Assert;

public class RunLengthEncoderDecoderTest {
    
    RunLengthEncoderDecoder encoderDecoder = new RunLengthEncoderDecoder();

    @Test
    public void simpleEncoder()
    {
        String str = "WWWMMMKKKkkk";
        Assert.assertEquals("W3M3K3k3",encoderDecoder.encode(str));
    }

    @Test
    public void encodeStringWithUniqueCharacters()
    {
        String str = "WMmK";
        Assert.assertEquals("W1M1m1K1", encoderDecoder.encode(str));
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
        String str = "WWWWWWWWWWWWWWWWWWWWWWWWWWMMMmmmMMMMMMMMMMMMMMMMMMMMKKKKKKKKKKKKKKKKKKKKWWW";
        Assert.assertEquals("W26M3m3M20K20W3", encoderDecoder.encode(str));
    }

    @Test
    public void simpleDecoder()
    {
        String str = "W3w2M3K3";
        Assert.assertEquals("WWWwwMMMKKK",encoderDecoder.decode(str));
    }

    @Test
    public void decodeStringWithUniqueCharacters()
    {
        String str = "W1M1K1u1";
        Assert.assertEquals("WMKu", encoderDecoder.decode(str));
    }

    @Test
    public void decodeMorethan10Characters()
    {
        String str = "W12M12N3m3";
        Assert.assertEquals("WWWWWWWWWWWWMMMMMMMMMMMMNNNmmm", encoderDecoder.decode(str));
    }
    @Test
    public void decodeMorethan100Characters()
    {
        String str = "w3W101M12N3";
        Assert.assertEquals("wwwWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW"+
        "MMMMMMMMMMMMNNN", encoderDecoder.decode(str));
    }

    @Test
    public void testEncoding()
    {
        char mode = 'E';
        String str = "WWWWWWWWWWWWWWWWWWWWWWWWWWMMMMMMMMMMMMMMMMMMMMMMMKKKKKKKKKKKKKKKKKKKKWWWccc";
        Assert.assertEquals("W26M23K20W3c3", encoderDecoder.encoderDecoder(mode, str));
    }

    @Test
    public void testDecoding()
    {
        char mode = 'D';
        String str = "W101M12N3d3";
        Assert.assertEquals("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW"+
        "MMMMMMMMMMMMNNNddd", encoderDecoder.encoderDecoder(mode,str));
    }


    
}
