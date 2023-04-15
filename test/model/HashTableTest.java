package model;

import Exceptions.HashNullException;
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

    public void setupStage2() {
        hashtable = new HashTableImplementation<>(5);
        hashtable.insert("Pablo", 748223);
        hashtable.insert("Pedro", 541561);
        hashtable.insert("Juan", 566541);
        hashtable.insert("Andrew", 724658);
        hashtable.insert("Alex", 934621);
    }

    public void setupStage3() {
        hashtableCats = new HashTableImplementation<>(12);
        hashtableCats.insert(8, new Cat("Timi", 4));
    }

    //Testing insert method
    @Test
    public void insertItems() throws HashNullException {
        //Arrange
        setupStage1();
        //Art
        hashtable.insert("Lola", 17263);
        hashtable.insert("Eduard", 51651);
        hashtable.insert("Alex", 54516);
        int number = hashtable.search("Eduard");
        //Assert
        assertEquals(number, 51651);
    }

    @Test
    public void insertMoreItemsThanSize() throws HashNullException {
        //Arrange
        setupStage2();
        //Art
        hashtable.insert("Mimi", 417245);
        hashtable.insert("Lola", 547147);
        int number = hashtable.search("Lola");
        //Arrange
        assertEquals(number, 547147);
    }

    @Test
    public void insertSameKeys() throws HashNullException {
        setupStage1();
        //Art
        hashtable.insert("Pepe", 417245);
        hashtable.insert("Pepe", 547147);
        int number = hashtable.search("Pepe");
        //Assert
        assertEquals(number, 547147);
    }

    //Testing search method
    @Test
    public void searchExistingItem() throws HashNullException {
        //Arrange
        setupStage2();
        //Art
        int number = hashtable.search("Pedro");
        //Assert
        assertEquals(number, 541561);
    }

    @Test
    public void searchNonExistingItemException() {
        //Arrange
        setupStage1();
        //Art
        hashtable.insert("Mom", 547814);
        //Assert
        assertThrows(HashNullException.class, () -> hashtable.search("Dad"));
    }

    @Test
    public void searchObject() throws HashNullException {
        //Arrange
        setupStage3();
        //Art
        Cat mimu = new Cat("Mimu", 45);
        hashtableCats.insert(14, mimu);
        Cat cat = hashtableCats.search(14);
        //Arrange
        assertEquals(cat, mimu);
    }

    //Testing delete method
    @Test
    public void deleteExistingItem() throws HashNullException {
        //Arrange
        setupStage2();
        //Art
        hashtable.delete("Juan");
        //Assert
        assertThrows(HashNullException.class, () -> hashtable.search("Juan"));
    }

    @Test
    public void deleteSameKeyItem() throws HashNullException {
        //Arrange
        setupStage1();
        //Art
        hashtable.insert("Ama", 521214);
        hashtable.insert("Ama", 541478);
        hashtable.delete("Ama");
        int number = hashtable.search("Ama");
        //Assert
        assertEquals(number, 521214);
    }

    @Test
    public void deleteObject() throws HashNullException {
        //Arrange
        setupStage3();
        //Art
        hashtableCats.delete(8);
        //Assert
        assertThrows(HashNullException.class, () -> hashtableCats.search(8));
    }
}
