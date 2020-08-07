import lesson6.ArrayFromArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
@RunWith(Parameterized.class)
public class TestMassArrayFromArray {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,1,1,1}, false},
                {new int[]{4,4,4,4}, false},
                {new int[]{1,4,1,4}, true},
                {new int[]{1,4,6,1}, false},
                {new int[]{0,0,0,0}, false}
        });
    }
    private int[] a;
    private boolean b;

    public TestMassArrayFromArray (int[] a, boolean b) {
        this.a = a;
        this.b = b;
    }

    ArrayFromArray arrayFromArray;

    @Before
    public void init () {
        arrayFromArray = new ArrayFromArray();
    }

    @Test
    public void test () {
        Assert.assertEquals(b, arrayFromArray.hasOneAndFour(a));
    }

}
