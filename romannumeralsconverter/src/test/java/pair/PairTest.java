package pair;

import io.neolab.internship.romannumeralsconverter.pair.Pair;
import org.junit.Assert;
import org.junit.Test;

public class PairTest {

    @Test
    public void shouldReturnFirstObjOfPair() {
        String stringForTesting = "Hi!";
        Pair pair = new Pair<>(stringForTesting, "Wow!");

        Assert.assertEquals(pair.getFirst(), stringForTesting);
    }

    @Test
    public void souldReturnSecondObjOfPair() {
        int intForTesting = 3;
        Pair pair = new Pair<Double, Integer>(2.5, intForTesting);

        Assert.assertEquals(intForTesting, pair.getSecond());
    }
}
