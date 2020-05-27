package ru.kpfu.itis.valeev;

import org.junit.Test;
import org.junit.Assert;

public class LinkedListTest {

    private MyLinkedList<Object> ll;

    @Test
    public void emptyLinkedListSizeTest() {
        ll = new MyLinkedList<>();
        Assert.assertEquals(0, ll.size());
    }

    @Test
    public void getFirstInEmptyLinkedListTest() {
        Assert.assertNull(ll.getFirst());
    }

    @Test
    public void linkedListAfterAddingSizeTest() {
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        Assert.assertEquals(3, ll.size());
    }

    @Test
    public void linkedListAfterUsingConstructorWithOtherLinkedListSizeTest() {
        MyLinkedList<Object> otherLL = new MyLinkedList<>();
        otherLL.addFirst(3);
        otherLL.addLast(2);
        otherLL.addLast(1);
        ll = new MyLinkedList<>(otherLL);
        Assert.assertEquals(3, ll.size());
    }

    @Test
    public void getFirstGetZeroTest() {
        Assert.assertEquals(ll.getFirst(),ll.get(0));
    }

    @Test
    public void getSizeAddLastTest() {
        ll.addLast(1000);
        Assert.assertEquals(1000,ll.get(ll.size()-1));
    }

    @Test
    public void indexOfLastElementAndSizeTest() {
        Assert.assertEquals(ll.indexOf(1000),ll.get(ll.size()-1));
    }

    @Test
    public void addAfterRightIndexOfTest() {
        ll.addAfter(0,"foo");
        Assert.assertEquals(1,ll.indexOf("foo"));
    }

    @Test
    public void sizeAfterRemoveByIndexTest() {
        ll.addLast("sss");
        ll.addLast("www");
        ll.addLast("vvv");
        ll.removeByIndex(3);
        int previousSize = ll.size();
        Assert.assertEquals(previousSize - 1, ll.size());
    }

    @Test
    public void hashCodeAfterRemovingTailTest() {
        int firstHash = ll.hashCode();
        ll.removeByValue("vvv");
        Assert.assertNotEquals(firstHash,ll.hashCode());
    }

    @Test
    public void afterMergeLinkedListHasNewTailTest() {
        MyLinkedList<Object> otherLL = new MyLinkedList<>();
        otherLL.addFirst("head");
        otherLL.addLast("body");
        otherLL.addLast("tail");
        ll.merge(otherLL);
        Assert.assertEquals("tail",ll.get(ll.size()-1));
    }

    @Test
    public void equalstest() {
        ll = new MyLinkedList<>();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        MyLinkedList<Object> otherLL = new MyLinkedList<>();
        otherLL.addFirst(1);
        otherLL.addLast(2);
        otherLL.addLast(3);
        Assert.assertTrue(ll.equals(otherLL));
    }
}
