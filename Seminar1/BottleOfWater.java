package ru.geekbrains;

public class BottleOfWater extends Product {

    private int volume; // объем

    public int getVolume() {
        return volume;
    }

    public BottleOfWater(String name, double price, int volume){
        super(name, price);
        this.volume = volume;
    }

    @Override
    public String displayInfo() {
        return String.format("%s - %s - %f - объем: %d", brand, name, price, volume);
    }
}
