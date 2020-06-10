package converter;

import io.neolab.internship.romannumeralsconverter.converter.RomanSystemConverter;
import io.neolab.internship.romannumeralsconverter.converter.RomanSystemConverterException;
import org.junit.Assert;
import org.junit.Test;

public class RomanSystemConverterTest {

    @Test
    public void shouldConvertCorrectlyAtFirst() throws RomanSystemConverterException {
        int input = 10;

        String output = RomanSystemConverter.getRomeNum(input);
        Assert.assertEquals(output, "X");
    }

    @Test
    public void shouldConvertCorrectlyAtSecond() throws RomanSystemConverterException {
        int input = 961;

        String output = RomanSystemConverter.getRomeNum(input);
        Assert.assertEquals(output,
                "C" + "M" +
                        "L" + "X" +
                        "I");
    }

    @Test
    public void shouldConvertCorrectlyAtThird() throws RomanSystemConverterException {
        int input = 9218;

        String output = RomanSystemConverter.getRomeNum(input);
        Assert.assertEquals(output,
                "M" + "X\u0305" +
                        "C" + "C" +
                        "X" +
                        "V" + "I" + "I" + "I");
    }

    @Test
    public void shouldConvertCorrectlyAtFourth() throws RomanSystemConverterException {
        int input = 99348;

        String output = RomanSystemConverter.getRomeNum(input);
        Assert.assertEquals(output,
                "X\u0305" + "C\u0305" +
                        "M" + "X\u0305" +
                        "C" + "C" + "C" +
                        "X" + "L" +
                        "V" + "I" + "I" + "I");
    }

    @Test
    public void souldConvertCorrectlyAtFifth() throws RomanSystemConverterException {
        int input = 37189213;

        // 1.000.000 = M` or I``

        String output = RomanSystemConverter.getRomeNum(input);
        Assert.assertEquals(output,
                "\u033FX" + "\u033FX" + "\u033FX" +
                        "\u033FV" + "\u033FI" + "\u033FI" +
                        "C\u0305" +
                        "L\u0305" + "X\u0305" + "X\u0305" + "X\u0305" +
                        "M" + "X\u0305" +
                        "C" + "C" +
                        "X" +
                        "I" + "I" + "I");
    }


    @Test(expected = RomanSystemConverterException.class)
    public void shouldThrowException() throws RomanSystemConverterException {
        RomanSystemConverter.getRomeNum(-1);
    }
}
