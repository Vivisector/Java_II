package HW;
import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();
    //метод добавления фрукта в коробку
    public void addFruit(T fruit){
        fruits.add(fruit);
    }

    public float getWeight(){
        if (fruits.size()==0){
            return 0.0f;
        }
        float weight = 0.0f;
        for (T fruit : fruits) {
            weight +=fruit.getWeight();
        } return weight;
    }

    public boolean compare(Box<?> anotherBox){
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    //метод пересыпания фруктов из одной коробки в коробку
    public void transfer(Box<T> anotherBox) {
        if (this == anotherBox) {
            return; // если коробка таже самая, ничего не делать
        }
        if (fruits.size() == 0) {
            return; // если в коробке нет фруктов, ничего не делать
        }
        if (anotherBox.fruits.size() > 0 && fruits.get(0).getClass() != anotherBox.fruits.get(0).getClass()) {
            return; //если типв фруктов в коробках не совпадают, ничего не делать
        }
        anotherBox.fruits.addAll(fruits);
        fruits.clear();
    }
}
