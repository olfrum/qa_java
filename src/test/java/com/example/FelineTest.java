package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {
    Feline feline = new Feline();

    @Test
    public void eatMeat() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }

    @Test
    public void getFamily() {
        String expected = "Кошачьи";
        assertEquals(expected, feline.getFamily());
    }

    @Test
    public void getKittens() {
        int expected = 1;
        assertEquals(expected, feline.getKittens());
    }

    @Test
    public void getManyKittens() {
        int expected = 10;
        assertEquals(expected, feline.getKittens(10));
    }
}