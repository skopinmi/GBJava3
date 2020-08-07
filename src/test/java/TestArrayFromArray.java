import lesson6.ArrayFromArray;
import org.junit.Assert;
import org.junit.Test;

public class TestArrayFromArray {
    ArrayFromArray arrayFromArray = new ArrayFromArray();

//    start from 4
    @Test
    public void test1 () {
        int [] a = {4, 2, 3, 1, 5};
        int [] b = {2, 3, 1, 5};
        Assert.assertArrayEquals(b, arrayFromArray.arrayAfterFour(a));
    }
//    4 end
    @Test
    public void test2 () {
        int [] a = {1, 2, 3, 5, 4};
        int [] b = {};
        Assert.assertArrayEquals(b, arrayFromArray.arrayAfterFour(a));
    }
//    4 in center
    @Test
    public void test3 () {
        int [] a = {1, 2, 4, 4, 5};
        int [] b = { 5};
        Assert.assertArrayEquals(b, arrayFromArray.arrayAfterFour(a));
    }
//    4 more 2
    @Test
    public void test4 () {
        int [] a = {4, 2, 3, 4, 5};
        int [] b = {5};
        Assert.assertArrayEquals(b, arrayFromArray.arrayAfterFour(a));
    }
//    not contain 4
    @Test(expected = RuntimeException.class)
    public void test5 () {
        int [] a = {1, 2, 3, 6, 5};
        int [] b = {1, 2, 3, 6, 5};
        Assert.assertArrayEquals(b, arrayFromArray.arrayAfterFour(a));
    }
}
