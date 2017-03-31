package ru.epam.training;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.util.Map;

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

    }

    @Test
    public void testThatMapCanPutPairWithKeyThatAlreadyPresented() {
        m.put(1,"1a");
        m.put(1,"1b");
        assertThat(m.containsValue("1b"), is(true));
        assertThat(m.containsValue("1a"), is(false));
    }

    @Test
    public void testThatMapCanContainsKeysWithSameHashCode() {
    }

    @Test(expected = NullPointerException.class)
    public void testThatContainsKeyMethodThrowsExceptionOnNullKey() {
        m.containsKey(null);
    }

    @Test
    public void testContainsValueMethodWorksProperlyOn() {
    }

    @Test
    public void testContainsValueMethodWorksProperlyOnNullInputValue() {
    }

    @Test
    public void testThatMapCalculateItsSizeProperly() {
    }

    @Test
    public void test() throws Exception {
    }
}
