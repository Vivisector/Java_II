package ru.geekbrains;

public class Chocolate extends Product {
    private int calories;

    public Chocolate(String name, String brand, double price, int calories) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String displayInfo() {
        //return super.displayInfo();
        return String.format("Шоколад %s - \"%s\" - Цена %f р. - калории: %d", brand, name, price, calories);
    }
}
