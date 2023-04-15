package model;

import Exceptions.StackNullException;
import model.objects.Cat;
import model.stacks.StackNodeImplementation;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    private StackNodeImplementation<Cat> catStack;
    private StackNodeImplementation<Integer> numStack;

    //Setups
    public void setupStage1() {
        catStack = new StackNodeImplementation<>();
    }

    public void setupStage2() {
        catStack = new StackNodeImplementation<>();
        catStack.push(new Cat("Lola", 4));
    }

    public void setupStage3() {
        numStack = new StackNodeImplementation<>();
    }

    //Testing push method
    @Test
    public void addItemToStack() throws StackNullException {
        setupStage1();
        catStack.push(new Cat("Nene", 7));
        assertEquals(catStack.top().getName(), "Nene");
    }

    @Test
    public void addManyItemsToStack() throws StackNullException {
        setupStage1();
        catStack.push(new Cat("Nene", 7));
        catStack.push(new Cat("Lola", 10));
        catStack.push(new Cat("Dash", 2));
        assertEquals(catStack.top().getName(), "Dash");
    }

    @Test
    public void addOtherObjectToStack() throws StackNullException {
        setupStage3();
        numStack.push(1);
        numStack.push(3);
        numStack.push(2);
        numStack.push(5);
        numStack.push(6);
        assertEquals(numStack.top().intValue(), 6);
    }

    //Testing isEmpty method

    @Test
    public void isEmptyWithoutItems() {
        //Arrange
        setupStage1();
        //Art
        boolean isEmpty = catStack.isEmpty();
        //Assert
        assertTrue(isEmpty);
    }

    @Test
    public void isEmptyAddingItems() {
        //Arrange
        setupStage1();
        //Art
        catStack.push(new Cat("Lola", 4));
        boolean isEmpty = catStack.isEmpty();
        //Assert
        assertFalse(isEmpty);
    }

    @Test
    public void isEmptyDeletingItem() throws StackNullException {
        //Arrange
        setupStage2();
        //Art
        catStack.pop();
        boolean isEmpty = catStack.isEmpty();
        //Assert
        assertTrue(isEmpty);
    }

    //Testing top method
    @Test
    public void topWithoutItemsException() throws StackNullException {
        //Arrange
        setupStage2();
        //Art
        catStack.pop();
        //Assert
        assertThrows(StackNullException.class, () -> catStack.top());
    }

    @Test
    public void topWithItems() throws StackNullException {
        //Arrange
        setupStage1();
        //Art
        catStack.push(new Cat("Bolt", 4));
        //Assert
        assertEquals(catStack.top().getAge(), 4);
    }

    @Test
    public void topChangesAddingItems() throws StackNullException {
        //Arrange
        setupStage3();
        //Art1
        numStack.push(5);
        numStack.push(4);
        numStack.push(1);
        //Assert1
        assertEquals(numStack.top().intValue(), 1);
        //Art2
        numStack.push(2);
        numStack.push(9);
        //Assert2
        assertEquals(numStack.top().intValue(), 9);
    }

    //Testing pop method
    @Test
    public void popWithItems() throws StackNullException {
        //Arrange
        setupStage2();
        //Art
        catStack.push(new Cat("Nene", 5));
        catStack.pop();
        //Assert
        assertEquals(catStack.top().getAge(), 4);
    }

    @Test
    public void popWithoutItemsException() throws StackNullException {
        setupStage2();
        //Art
        catStack.pop();
        //Assert
        assertThrows(StackNullException.class, () -> catStack.pop());
    }

    @Test
    public void popReturnsDeletedItem() throws StackNullException {
        setupStage3();
        //Art
        numStack.push(5);
        numStack.push(3);
        numStack.push(2);
        numStack.push(4);
        numStack.push(6);
        //Arrange
        assertEquals(numStack.pop().intValue(), 6);
    }
}
