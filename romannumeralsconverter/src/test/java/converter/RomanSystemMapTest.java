package converter;

import io.neolab.internship.romannumeralsconverter.converter.RomanSystemMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

public class RomanSystemMapTest {
    private RomanSystemMap romanSystemMap;

    @Before
    public void setUp() {
        romanSystemMap = new RomanSystemMap();
    }

    @Test
    public void shouldReturnThousandInRomanSystem() {
        Assert.assertEquals(romanSystemMap.getValue(100), "C");
    }

    @Test
    public void shouldReturnAllKeys() {

        romanSystemMap = new RomanSystemMap();
        Set<Integer> numberSet = new TreeSet<>();

        int [] keys = {
                1, 4, 5, 9, 10, 40, 50, 90,
                100, 400, 500, 900,
                1000, 4000, 5000, 9000
        };

        for (Integer key : keys) {
            numberSet.add(key);
        }
        Assert.assertEquals(romanSystemMap.getKeys(), numberSet);
    }
}
