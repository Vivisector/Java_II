import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Cat[] cats = {
        new Cat("Bars", 5),
        new Cat("Tigr", 10),
        new Cat("Diablo", 15)
        };

        Plate plate = new Plate(10);
        System.out.printf("Сейчас в тарелке %d кило еды\n", plate.getFood());
    
        feedCats(cats, plate); // первая кормежка
        checkHungry(cats); // проверка накормленности
        if (checkHungry(cats)){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Количество еды для добавления в тарелку: ");
            int amount = scanner.nextInt();
            scanner.close();
            plate.addFood(amount);
            System.out.println("Добавочная кормежка...");
            feedCats(cats, plate); // повторная кормежка, если кто-то не наелся
        }
    
    }

    public static void feedCats(Cat[] cats, Plate plate) {
        for (Cat cat : cats){
            cat.eat(plate);
            System.out.println(cat.getName() + (cat.isFilled() ? " наелся" : " еще не наелся"));
        }
    }

    private static boolean checkHungry(Cat[] cats) {
        for (Cat cat : cats){
            if (cat.isFilled()) {
                return true;
            }
        }
        return false;
    }


}
