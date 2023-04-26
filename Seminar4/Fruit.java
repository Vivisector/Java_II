package HW;

public abstract class Fruit {
    // поле
    private final float weight;
    //конструктор
    public Fruit(float weight){
        this.weight = weight;
    }
    //getter
    public float getWeight(){
        return weight;
    }
}

