package model;

import Exceptions.QueueNullException;
import model.objects.Cat;
import model.queues.QueueNodeImplementation;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    private QueueNodeImplementation<Cat> catQueue;
    private QueueNodeImplementation<String> stringQueue;

    //Setups
    public void setupStage1() {
        catQueue = new QueueNodeImplementation<>();
    }

    public void setupStage2() {
        stringQueue = new QueueNodeImplementation<>();
    }

    public void setupStage3() {
        catQueue = new QueueNodeImplementation<>();
        catQueue.enqueue(new Cat("Lola", 4));
        catQueue.enqueue(new Cat("Pepe", 2));
        catQueue.enqueue(new Cat("Mimi", 1));
    }

    public void setupStage4() {
        stringQueue = new QueueNodeImplementation<>();
        stringQueue.enqueue("Bird");
    }

    //Testing enqueue method
    @Test
    public void enqueueOneItem() throws QueueNullException {
        //Arrange
        setupStage1();
        //Art
        catQueue.enqueue(new Cat("Jim", 7));
        //Assert
        assertEquals(catQueue.front().getName(), "Jim");
    }

    @Test
    public void enqueueOtherObject() throws QueueNullException {
        //Arrange
        setupStage2();
        //Art
        stringQueue.enqueue("Ala");
        //Assert
        assertEquals(stringQueue.front(), "Ala");
    }

    @Test
    public void enqueueManyItems() throws QueueNullException {
        //Arrange
        setupStage2();
        //Art
        stringQueue.enqueue("Hola");
        stringQueue.enqueue("soy");
        stringQueue.enqueue("Juan");
        stringQueue.enqueue("Manuel");
        //Assert
        assertEquals(stringQueue.front(), "Hola");
    }

    //Testing isEmpty method
    @Test
    public void isEmptyWithoutItems() {
        //Arrange
        setupStage1();
        //Art
        boolean isEmpty = catQueue.isEmpty();
        //Assert
        assertTrue(isEmpty);
    }

    @Test
    public void isEmptyWithItems() {
        //Arrange
        setupStage3();
        //Art
        boolean isEmpty = catQueue.isEmpty();
        //Assert
        assertFalse(isEmpty);
    }

    @Test
    public void isEmptyDeletingItems() throws QueueNullException {
        //Arrange
        setupStage3();
        //Art
        catQueue.dequeue();
        catQueue.dequeue();
        catQueue.dequeue();
        boolean isEmpty = catQueue.isEmpty();
        //Assert
        assertTrue(isEmpty);
    }

    //Testing dequeue method
    @Test
    public void dequeueWithoutItemsException() throws QueueNullException {
        //Arrange
        setupStage4();
        //Art
        stringQueue.dequeue();
        //Assert
        assertThrows(QueueNullException.class, () -> stringQueue.dequeue());
    }

    @Test
    public void dequeueReturnsDeletedItem() throws QueueNullException {
        //Arrange
        setupStage3();
        //Art
        Cat cat = catQueue.dequeue();
        //Assert
        assertEquals(cat.getName(), "Lola");
    }

    @Test
    public void dequeueDeletesInOrder() throws QueueNullException {
        //Arrange
        setupStage3();
        //Art1
        Cat cat = catQueue.dequeue();
        //Assert1
        assertEquals(cat.getName(), "Lola");
        //Art2
        cat = catQueue.dequeue();
        //Assert2
        assertEquals(cat.getName(), "Pepe");
        //Art3
        cat = catQueue.dequeue();
        //Assert3
        assertEquals(cat.getName(), "Mimi");
    }

    //Testing front method
    @Test
    public void frontWithoutItemsException() throws QueueNullException {
        //Arrange
        setupStage4();
        //Art
        stringQueue.dequeue();
        //Assert
        assertThrows(QueueNullException.class, () -> stringQueue.front());
    }

    @Test
    public void frontWithItems() throws QueueNullException {
        //Arrange
        setupStage2();
        //Art
        stringQueue.enqueue("Marin");
        //Assert
        assertEquals(stringQueue.front(), "Marin");
    }

    @Test
    public void frontInOrder() throws QueueNullException {
        //Arrange
        setupStage3();
        //Art1
        Cat cat = catQueue.front();
        catQueue.dequeue();
        //Assert1
        assertEquals(cat.getName(), "Lola");
        //Art1
        cat = catQueue.front();
        catQueue.dequeue();
        //Assert1
        assertEquals(cat.getName(), "Pepe");
        //Art1
        cat = catQueue.front();
        catQueue.dequeue();
        //Assert1
        assertEquals(cat.getName(), "Mimi");
    }
}
