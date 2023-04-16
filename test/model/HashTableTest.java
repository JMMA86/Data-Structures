package model;

import Exceptions.HashKeyException;
import model.hashtables.HashTableImplementation;
import model.objects.Cat;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest {
    HashTableImplementation<String, Integer> hashtable; //Simulating contacts
    HashTableImplementation<Integer, Cat> hashtableCats; //Simulating sale of cats

    //Setups
    public void setupStage1() {
        hashtable = new HashTableImplementation<>(3);
    }

    public void setupStage2() throws HashKeyException {
        hashtable = new HashTableImplementation<>(5);
        hashtable.insert("Pablo", 748223);
        hashtable.insert("Pedro", 541561);
        hashtable.insert("Juan", 566541);
        hashtable.insert("Andrew", 724658);
        hashtable.insert("Alex", 934621);
    }

    public void setupStage3() throws HashKeyException {
        hashtableCats = new HashTableImplementation<>(12);
        hashtableCats.insert(8, new Cat("Timi", 4));
    }

    //Testing insert method
    @Test
    public void insertItems() throws HashKeyException {
        //Arrange
        setupStage1();
        //Art
        hashtable.insert("Lola", 17263);
        hashtable.insert("Eduard", 51651);
        hashtable.insert("Alex", 54516);
        int number1 = hashtable.search("Lola");
        int number2 = hashtable.search("Eduard");
        int number3 = hashtable.search("Alex");
        //Assert
        assertEquals(number1, 17263);
        assertEquals(number2, 51651);
        assertEquals(number3, 54516);

    }

    @Test
    public void insertMoreItemsThanSize() throws HashKeyException {
        //Arrange
        setupStage2();
        //Art
        hashtable.insert("Mimi", 417245);
        hashtable.insert("Lola", 547147);
        int number1 = hashtable.search("Mimi");
        int number2 = hashtable.search("Lola");
        //Arrange
        assertEquals(number1, 417245);
        assertEquals(number2, 547147);
    }

    @Test
    public void insertSameKeysException() throws HashKeyException {
        setupStage1();
        //Art
        hashtable.insert("Pepe", 417245);
        //Assert
        assertThrows(HashKeyException.class, () -> hashtable.insert("Pepe", 241587));
    }

    //Testing search method
    @Test
    public void searchExistingItem() throws HashKeyException {
        //Arrange
        setupStage2();
        //Art
        int number = hashtable.search("Pedro");
        //Assert
        assertEquals(number, 541561);
    }

    @Test
    public void searchNonExistingItem() throws HashKeyException {
        //Arrange
        setupStage1();
        //Art
        hashtable.insert("Mom", 547814);
        //Assert
        assertNull(hashtable.search("Dad"));
    }

    @Test
    public void searchObject() throws HashKeyException {
        //Arrange
        setupStage3();
        //Art
        Cat meow = new Cat("Meow", 45);
        hashtableCats.insert(14, meow);
        //Arrange
        assertEquals(hashtableCats.search(14), meow);
    }

    //Testing delete method
    @Test
    public void deleteExistingItem() throws HashKeyException {
        //Arrange
        setupStage2();
        //Art
        hashtable.delete("Juan");
        //Assert
        assertNull(hashtable.search("Juan"));
    }

    @Test
    public void deleteManyItems() throws HashKeyException {
        //Arrange
        setupStage2();
        //Art
        hashtable.delete("Pablo");
        hashtable.delete("Pedro");
        hashtable.delete("Juan");
        hashtable.delete("Andrew");
        //Assert
        assertNull(hashtable.search("Pablo"));
        assertNull(hashtable.search("Pedro"));
        assertNull(hashtable.search("Juan"));
        assertNull(hashtable.search("Andrew"));
    }

    @Test
    public void deleteObject() throws HashKeyException {
        //Arrange
        setupStage3();
        //Art
        hashtableCats.delete(8);
        //Assert
        assertNull(hashtableCats.search(8));
    }
}
