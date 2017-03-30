package ru.epam.training;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CustomListsTest {

    private List<String> list;

    public CustomListsTest(List<String> list) {
        this.list = list;
    }

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[]{
                new CustomArrayList(),
                new CustomLinkedList()
        });
    }

    @Before
    public void init() {
        list.clear();
    }

    @Test
    public void testThatNewListIsEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void testThatListNotEmptyAfterAddingElement() {
        list.add("aaaa");
        assertThat(list.isEmpty(), is(false));
    }

    @Test
    public void testThatListContainsElementThatWeAddedBefore() {
        String value = "bbb";

        list.add(value);

        assertTrue(list.contains(value));
    }

    @Test
    public void testThatListNotContainsElementThatWasntAddedToList() throws Exception {
        list.add("fff");
        assertFalse(list.contains("ccc"));
    }

    @Test
    public void testThatListContainsNullIfItWasAdded() {

        list.add(null);

        assertTrue(list.contains(null));
    }

    @Test
    public void testThatListNotContainsNullIfItWasNotAdded() {
        list.add("fff");
        assertFalse(list.contains(null));
    }

    @Test
    public void testThatListsSizeIsDynamic() throws Exception {
        int size = 50;

        for (int i = 0; i < size; i++) {
            list.add(String.valueOf(i));
        }

        assertThat(list.size(), is(size));
    }

    @Test
    public void testThatWeCanGetElementByIndex() {

        fillList();

        assertThat(list.get(1), is(equalTo("aa1a")));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThatWeCantGetElementByIndexMoreThenSize() throws Exception {

        fillList();

        list.get(list.size());
    }

    @Test
    public void testThatWeCanRemoveExistedElementFromList() throws Exception {
        fillList();

        list.remove("ssss");

        assertFalse("contains", list.contains("ssss"));
    }

    @Test
    public void testThatWeCanDeleteElementByIndex() throws Exception {
        fillList();

        String removed = list.remove(2);

        assertFalse(list.contains("aa2a"));
        assertThat(removed, is(equalTo("aa2a")));
    }

    @Test
    public void testThatWeCanDeleteLastElement() throws Exception {
        fillList();

        int prevSize = list.size();

        list.remove(list.size() - 1);

        assertFalse(list.contains("aa4a"));
        assertThat(list.size(), is(equalTo(prevSize - 1)));
    }

    @Test
    public void testThatWeCantDeleteNonExistentElement() throws Exception {
        fillList();

        assertFalse(list.remove("sadasdasd"));
    }

    @Test
    public void testThatWeCanAddElementIntoCustomPosition() throws Exception {
        fillList();

        int oldSize = list.size();

        String addedElement = "aaa5";
        list.add(3, addedElement);

        assertThat(list.contains(addedElement), is(true));

        assertThat(list.size(), is(equalTo(oldSize + 1)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThatWeCantAddElementByIndexOutOfCurrentSizePlusOne() throws Exception {
        fillList();

        int oldSize = list.size();

        String addedElement = "aaa5";
        list.add(list.size() + 1, addedElement);

        assertThat(list.contains(addedElement), is(true));

        assertThat(list.size(), is(equalTo(oldSize + 1)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThatWeCantRemoveElementByIndexOutOfBound() throws Exception {
        fillList();

        list.remove(list.size());
    }

    @Test
    public void testThatWeCanGetIndexOfValue() throws Exception {
        fillList();

        int indexOf = list.indexOf("aa4a");

        assertThat(indexOf, equalTo(4));
    }

    @Test
    public void testThatIndexOfNonsexistValueIsNegative() throws Exception {
        fillList();

        int indexOf = list.indexOf("q's");

        assertThat(indexOf, equalTo(-1));
    }

    @Test
    public void testThatWeCanGetSublistByIbexes() throws Exception {
        fillList();

        List<String> subList = list.subList(0, list.size() - 1);

        assertEquals(list, subList);
    }

    @Test
    public void testThatWeCanAddAllElementFromOtherCollection() throws Exception {
        fillList();

        List<String> list2 = new ArrayList();
        list2.add("aa5a");
        list2.add("aa6a");
        list2.add("aa7a");
        list.addAll(list2);
        for (int i = 0; i < list2.size(); i++) {
            assertThat(list.contains(list2.get(i)), is(true));
        }
    }

    private void fillList() {
        list.add("aa0a");
        list.add("aa1a");
        list.add("aa2a");
        list.add("aa3a");
        list.add("aa4a");
    }
}
