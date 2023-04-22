public class Plate {
    private int food;

        //конструктор
    public Plate(int food) {
        this.food = food;
    }
    
    //метод
    public void info() {
        System.out.println("plate: " + food);
    }
    
    public int getFood() {
        return food;
    }

    //метод добавления еды в тарелку
    public void setFood(int food) {
        this.food = food;
    }

    //метод убывания еды в тарелке
    public void decreaseFood(int amount){
        food -= amount;
        if( food < 0){
            food = 0;
        }
    }

    public void addFood(int amount) {
        food += amount;
    }


    
}
