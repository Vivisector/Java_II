import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Cat[] cats = {
        new Cat("Bars", 5),
        new Cat("Tiger", 10),
        new Cat("Diablo", 15)
        };

        Plate plate = new Plate(15);
        System.out.printf("Сейчас в тарелке %d кило еды\n", plate.getFood());

    
        feedCats(cats, plate); // первая кормежка
        // если остались голодные добавляем еды
        if (isHungry(cats)){
                System.out.println("Есть недокормленные, поэтому добавим еды: ");  
                plate.addFood(getFoodToAddFromUser());
                System.out.println("Теперь в тарелке " + plate.getFood() + " кило");
                // plate.info();
                feedCats(cats, plate); // повторная кормежка, если кто-то не наелся
                }
                while (isHungry(cats)){
                    System.out.println("Остались недокормленные, поэтому добавим 5 кило: ");  
                    // plate.addFood(getFoodToAddFromUser());
                    plate.addFood(5);
                    System.out.println("Теперь в тарелке " + plate.getFood() + " кило");
                    feedCats(cats, plate); // повторная кормежка, если кто-то не наелся
                }
        }
    
        // кормежка
    public static void feedCats(Cat[] cats, Plate plate) {
        for (Cat cat : cats){
            if (!cat.isFilled() && plate.getFood() >= cat.getAppetite()){
            cat.eat(plate);}
            System.out.println(cat.getName() + (cat.isFilled() ? " наелся" : " еще не наелся"));
        }
    }

    private static boolean isHungry(Cat[] cats) {
        for (Cat cat : cats){
            if (!cat.isFilled()) {
                return true;
            }
        }
        return false;
    }
// Добавляем еды в тарелку
    private static int getFoodToAddFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько кило добавим?");
        int foodToAdd = scanner.nextInt();
        scanner.close();
        return foodToAdd;
    }

}
