package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {

    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime(){
        int result = 0;
        for(Dish dish : dishes){
            result+=dish.getDuration();
        }
        return result;
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    @Override
    public String toString() {
        if (this.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (Dish dish : dishes)
            sb.append(dish).append(", ");
        return String.format("Your order: [%s] of %s", sb.toString().substring(0, sb.length() - 2), tablet.toString());
    }
}
