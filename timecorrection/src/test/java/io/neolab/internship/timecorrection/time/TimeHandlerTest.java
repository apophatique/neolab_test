package io.neolab.internship.timecorrection.time;

import org.junit.Assert;
import org.junit.Test;

public class TimeHandlerTest {

    @Test(expected = TimeValidFormatException.class)
    public void shouldThrowExceptionAtFirst() throws TimeValidFormatException {
        String inputString = "01:01:2\ns";
        TimeHandler.formatDate(inputString);
    }

    @Test(expected = TimeValidFormatException.class)
    public void shouldThrowExceptionAtSecond() throws TimeValidFormatException {
        String inputString = "01:01::01";
        TimeHandler.formatDate(inputString);
    }

    @Test(expected = TimeValidFormatException.class)
    public void shouldThrowExceptionAtThird() throws TimeValidFormatException {
        String inputString = "1.01.2";
        TimeHandler.formatDate(inputString);
    }

    @Test
    public void shouldWorkCorrectlyWithEmpty() throws TimeValidFormatException {
        String inputString = "";
        String expectedString = "";

        Assert.assertEquals(expectedString, TimeHandler.formatDate(inputString));
    }

    @Test
    public void shouldWorkCorrectlyAtFirst() throws TimeValidFormatException {
        String inputString = "100:100:100";
        String expectedString = "05:41:40";

        Assert.assertEquals(expectedString, TimeHandler.formatDate(inputString));
    }

    @Test
    public void shouldWorkCorrectlyAtSecond() throws TimeValidFormatException {
        String inputString = "09:10:01";
        String expectedString = "09:10:01";

        Assert.assertEquals(expectedString, TimeHandler.formatDate(inputString));
    }

    @Test
    public void shouldWorkCorrectlyAtThird() throws TimeValidFormatException {
        String inputString = "11:70:10";
        String expectedString = "12:10:10";

        Assert.assertEquals(expectedString, TimeHandler.formatDate(inputString));
    }

    @Test
    public void shouldWorkCorrectlyAtFourth() throws TimeValidFormatException {
        String inputString = "19:99:99";
        String expectedString = "20:40:39";

        Assert.assertEquals(expectedString, TimeHandler.formatDate(inputString));
    }

    @Test
    public void shouldWorkCorrectlyAtFifth() throws TimeValidFormatException {
        String inputString = "24:01:01";
        String expectedString = "00:01:01";

        Assert.assertEquals(expectedString, TimeHandler.formatDate(inputString));
    }

}
