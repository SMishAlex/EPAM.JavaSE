package ru.epam.training;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.util.Map;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

@FixMethodOrder
public class CustomHashMapTest {

    private Map<Integer, String> m;

    @Before
    public void init() {
        m = new CustomHashMap<>();
    }

    @Test
    public void testThatWeCanCreate() {

        assertThat(m, is(notNullValue()));
    }

    @Test
    public void testThatNewMapIsEmpty() {
        assertThat(m.isEmpty(), is(true));
    }

    @Test
    public void testThatOnNewMapContainKeyMethodReturnFalseForAnyObject() {
        assertThat(m.containsKey(new Integer(1)), is(false));
    }

    @Test
    public void testThatWeCanPutKeyValuePairAndCanCheckIt() {
        m.put(new Integer(3), "abc");
        assertThat(m.containsKey(3), is(true));
    }

    @Test(expected = NullPointerException.class)
    public void testThatWeCantPutNullKey() {
        m.put(null, "abc");
    }

    @Test
    public void testThatWeCanPutNullValue() {
        m.put(1, null);
        assertThat(m.containsValue(null), is(true));
    }

    @Test
    public void testThatMapHaveDynamicCapacity() {
        IntStream.range(1, 320).forEach(
                i -> m.put(i, String.valueOf(i))
        );

        IntStream.range(1, 320).forEach(
                i -> assertThat(m.containsKey(i), is(true))
        );
    }

    @Test
    public void testThatMapCanPutPairWithKeyThatAlreadyPresented() {
        m.put(1, "1a");
        m.put(1, "1b");
        assertThat(m.containsValue("1b"), is(true));
        assertThat(m.containsValue("1a"), is(false));
    }

    @Test
    public void testThatMapCanContainsMoreThenOneEntryInOneBucket() {
        IntStream.range(1, 32).forEach(
                i -> m.put(i, String.valueOf(i))
        );

        IntStream.range(1, 32).forEach(
                i -> assertThat(m.containsValue(String.valueOf(i)), is(true))
        );
    }

    @Test(expected = NullPointerException.class)
    public void testThatContainsKeyMethodThrowsExceptionOnNullKey() {
        m.containsKey(null);
    }

    @Test
    public void testContainsValueMethodWorksProperlyOn() {
        IntStream.range(1, 10).forEach(
                i -> m.put(i, String.valueOf(i))
        );

        IntStream.range(1, 10).forEach(
                i -> assertThat(m.containsValue(String.valueOf(i)), is(true))
        );
    }

    @Test
    public void testContainsValueMethodWorksProperlyOnNullInputValue() {
        IntStream.range(1, 10).forEach(
                i -> m.put(i, String.valueOf(i))
        );

        assertThat(m.containsValue(null), is(false));

        m.put(100, null);

        assertThat(m.containsValue(null), is(true));
    }

    @Test
    public void testThatMapCalculateItsSizeProperly() {
        IntStream.range(1, 10).forEach(
                i -> m.put(i, String.valueOf(i))
        );

        assertThat(m.size(), is(equalTo(9)));
    }

    @Test
    public void testThatWeCanRemoveEntryByKey() throws Exception {
        IntStream.range(1, 10).forEach(
                i -> m.put(i, String.valueOf(i))
        );

        m.remove(1);
        m.remove(10);
        m.remove(5);


        assertThat(m.containsKey(1), is(false));
        assertThat(m.containsKey(10), is(false));
        assertThat(m.containsKey(5), is(false));
    }
}
