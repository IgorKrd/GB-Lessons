import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class SomeThingForTestingOneTest1 {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][]{

                {new int[]{1, 2, 12, 3, 4, 0, 13, 6}, new int[]{0, 13, 6}},
                {new int[]{3, 5, 6, 4, 2, 5, 8}, new int[]{2, 5, 8}},
                {new int[]{12, 0, 5, 4, 3, 4, 23, 33, 5}, new int[]{23, 33, 5}}
        });
    }

    private int[] in;
    private int[] out;

    public SomeThingForTestingOneTest1(int[] in, int[] out) {
        this.in = in;
        this.out = out;
    }

    private SomeThingForTestingOne someThingForTestingOne;

    @Before
    public void startTest() {
        someThingForTestingOne = new SomeThingForTestingOne();
    }

    @Test
    public void testTakeawayAfterFour() {

        Assert.assertArrayEquals(out, SomeThingForTestingOne.TakeawayAfterFour(in));
    }

    @Test(expected = RuntimeException.class)
    public void testTakeawayAfterFourException() {
        SomeThingForTestingOne.TakeawayAfterFour(new int[]{5, 3, 1, 2, 12, 7, 8});

    }
}
