package ru.kpfu.itis.valeev;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class ModifiableCollectionTest {

    private ModifiableCollection<Object> mc;

    // 10 tests
    // TestClass_TestMethod_ConditionAndExpectedResult

    @Test
    public void emptyCollectionSizeTest() {
        mc = new ModifiableCollection<>();
        Assert.assertEquals(0, mc.size());
    }

    @Test
    public void testAddBoolean() {
        Assert.assertTrue(mc.add(new Object()));
    }

    @Test
    public void collectionAfterAddingTest() {
        mc.add(new Object());
        mc.add("foo");
        mc.add("bar");
        Assert.assertEquals(3, mc.size());
    }

    @Test
    public void sizeOfCollectionAfterAddingTest() {
        Assert.assertNotEquals(0, mc.size());
    }

    @Test
    public void sizeAfterConstructorWithCollectionsTest() {
        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        mc = new ModifiableCollection<>(list);
        Assert.assertEquals(5, mc.size());
    }

    @Test
    public void equalsTest() {
        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Assert.assertTrue(mc.equals(list));
    }

    @Test
    public void iteratorNotNullTest() {
        Assert.assertNotNull(mc.iterator());
    }


    @Test
    public void hashCodeNotEqualsTest() {
        ModifiableCollection<Object> otherMC = new ModifiableCollection<>();
        otherMC.add(1);
        otherMC.add(2);
        otherMC.add(3);
        otherMC.add(4);
        otherMC.add(5);
        Assert.assertNotEquals(mc.hashCode(), otherMC.hashCode());
    }

    @Test
    public void hashCodeForEvenNumberTest() {
        Assert.assertNotEquals(222,mc.hashCode());
    }

    @Test
    public void ineratorHasNextAtTheBeginnigEqualsTrueTest() {
        Assert.assertTrue(mc.iterator().hasNext());
    }

}
