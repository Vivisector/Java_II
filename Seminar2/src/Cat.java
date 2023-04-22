public class Cat {
    // поля
    private String name;
    private int appetite;
    boolean filled;
    //конструктор
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.filled = false;
    }
    // метод еды
    public void eat(Plate plate) {
        if (plate.getFood() >= appetite && !filled){
            plate.decreaseFood(appetite);
            filled = true;
        }
    }

    // определитель: наелся или нет
    public boolean isFilled(){
        return filled;
    }

    // получатель имени кота
    public String getName() {
        return this.name;
    }

    // получатель аппетита кота
    public int getAppetite(){
        return this.appetite;
    }
}
