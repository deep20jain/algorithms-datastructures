package contest.no96;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by deep20jain on 01-09-2018.
 */
public class DecodedStringAtIndexTest {

    @Test
    public void test1() {
        verify("leet2code3", 10 , "o");
    }

    @Test
    public void test2() {
        verify("ha22", 5 , "h");
    }

    @Test
    public void test3() {
        verify("a2345678999999999999999", 1 , "a");
    }

    @Test
    public void test4() {
        verify("vk6u5xhq9v", 554 , "k");
    }

    @Test
    public void test5() {
        verify("a2b3c4d5e6f7g8h9", 9 , "b");
    }

    public void verify(String input, int index, String output) {
        DecodedStringAtIndex decodedStringAtIndex = new DecodedStringAtIndex();
        String result = decodedStringAtIndex.decodeAtIndex(input, index);
        Assert.assertEquals(output, result);
    }
}
