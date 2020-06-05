package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

        public static List<Dish> getAllDishesForOrder() throws IOException {
            List<Dish> order = new ArrayList<>();
            writeMessage("Введите название блюда для добавления в заказ и exit для выхода.");
            writeMessage("Доступные блюда");
            for (Dish dish : Dish.values()){
                System.out.print(dish + " ");
            }
            while (true) {
                String task = readString();
                if (task.equals("exit")) {
                    break;
                }
                try {
                    order.add(Dish.valueOf(task));
                }
                catch (Exception e){
                    System.out.println("Такого блюда не существует.");
                }
            }
            return order;
        }
}
