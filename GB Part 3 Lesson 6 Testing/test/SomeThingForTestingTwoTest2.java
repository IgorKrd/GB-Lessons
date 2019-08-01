
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class SomeThingForTestingTwoTest2 {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{4, 4, 4, 4, 1, 1, 4, 1, 1}, true},
                {new int[]{4, 1, 4, 1, 4, 1, 4, 1}, true},
                {new int[]{3, 7, 9, 11, 0, 1, 5, 1}, false},
                {new int[]{2, 7, 4, 5}, false}
        });
    }

    private int[] in;
    private boolean out;

    public SomeThingForTestingTwoTest2(int[] in, boolean out) {
        this.in = in;
        this.out = out;
    }

    private SomeThingForTestingTwo someThingForTestingTwo;

    @Before
    public void startTest() {
        someThingForTestingTwo = new SomeThingForTestingTwo();
    }

    @Test
    public void testIsArrayWithoutOneOrFour() {
        Assert.assertEquals(SomeThingForTestingTwo.isArrayWithoutOneOrFour(in), out);
    }
}
