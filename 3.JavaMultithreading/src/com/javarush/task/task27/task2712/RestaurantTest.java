package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;
import org.junit.Assert;
import org.junit.Test;

public class RestaurantTest {

    @Test
    public void dishTestString() {
        Assert.assertEquals("FISH, STEAK, SOUP, JUICE, WATER", Dish.allDishesToString());
        System.out.println("Well Done");
    }
}