package ru.geekbrains;

import java.util.List;

public class VendingMachine {

    private final List<Product> products;

    public VendingMachine(List<Product> products) {
        this.products = products;
    }

    public BottleOfWater getBottleOfWater(String name, int volume){
        for (Product product: products) {
            if (product instanceof BottleOfWater){
                BottleOfWater bottle = ((BottleOfWater)product);
                if (bottle.name.equals(name) && bottle.getVolume() == volume)
                    return bottle;
            }
        }
        return null;
    }

    public Chocolate getChocolate(int calories){
        for (Product product: products) {
            if (product instanceof Chocolate){
                Chocolate chocolate = ((Chocolate)product);
                // if (chocolate.name.equals(name) && chocolate.getCalories() == volume)
                if (chocolate.getCalories() == calories)
                    return chocolate;
            }
        }
        return null;
    }

}
