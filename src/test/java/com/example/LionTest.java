package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    private final String sex;
    private final boolean hasMane;

    public LionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters(name = "Пол: {0}, Имеет гриву: {1}")
    public static Object[][] getSex() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Котёнок", false}
        };
    }

    @Mock
    Predator feline;

    @Test
    public void doesHaveMane() throws Exception {
        try {
            Lion lion = new Lion(feline, sex);
            Assert.assertEquals(hasMane, lion.doesHaveMane());
        } catch (Exception e) {
            String exception = e.getMessage();
            String expected = "Используйте допустимые значения пола животного - самей или самка";
            Assert.assertEquals(expected, exception);
        }
    }

    @RunWith(MockitoJUnitRunner.class)
    public static class LionCausalTest {
        @Mock
        Predator feline;

        @Test
        public void getKittens() throws Exception {
            int kittensCount = 1;
            Mockito.when(feline.getKittens()).thenReturn(1);
            Lion lion = new Lion(feline, "Самец");
            Assert.assertEquals(kittensCount, lion.getKittens());
        }

        @Test
        public void getFoodTest() throws Exception {
            Predator feline = new Feline();
            Lion lion = new Lion(feline, "Самец");
            List<String> expected = List.of("Животные", "Птицы", "Рыба");
            Assert.assertEquals(expected, lion.getFood());
        }
    }
}