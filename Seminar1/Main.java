package ru.geekbrains;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Product bottleOfWater1 = new BottleOfWater("Бутылка1", 100, 2);
        Product bottleOfMilk1 = new BottleOfMilk("Молоко", 200, 1, 10);
        Product bottleOfWater2 = new BottleOfWater("Бутылка2", 100, 1);
        Product bottleOfWater3 = new BottleOfWater("Бутылка3", 100, 2);
        Product bottleOfWater4 = new BottleOfWater("Бутылка3", 100, 2);
        Product chocolate1 = new Chocolate ("Балет", "Бабаевский", 85, 200);
        Product chocolate2 = new Chocolate ("Alpina", "Wienn", 125, 220);

        List<Product> products = new ArrayList<>();
        products.add(bottleOfWater1);
        products.add(bottleOfMilk1);
        products.add(bottleOfWater2);
        products.add(bottleOfWater3);
        products.add(bottleOfWater4);
        products.add(chocolate1);
        products.add(chocolate2);
        System.out.println("Список имеющихся в автомате продуктов:");
        for (Product prod : products){
            System.out.println(prod.displayInfo());
        }
        
        VendingMachine vendingMachine = new VendingMachine(products);

        System.out.println("Из этого вы купили: ");
        BottleOfWater bottleOfWaterRes = vendingMachine.getBottleOfWater("Бутылка2", 1);
        if (bottleOfWaterRes != null){
            // System.out.println("Вы купили: ");
            System.out.println(bottleOfWaterRes.displayInfo());
        }
        else {
            System.out.println("Такой бутылки с водой нет в автомате.");
        }

        Chocolate сhocolate = vendingMachine.getChocolate(220);
        if (сhocolate != null){
            // System.out.println("Вы купили: ");
            System.out.println(сhocolate.displayInfo());
        }
        else {
            System.out.println("Такого шоколада нет в автомате.");
        }
    }
}
