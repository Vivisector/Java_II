package ru.geekbrains;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Sample02 {

    private static Random random = new Random();
    private static int employeeCounter = 1;

    public static Employee generateEmployee(){
        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };

        int salary = random.nextInt(900, 1500);
        int salaryIndex = random.nextInt(28, 31);
        int age = random.nextInt(20,50);

         int type = random.nextInt(0,3);
        //  int id = random.nextInt(1000, 9999); // если нужен более случайный id
        
        if(type == 0){
            return new Worker(employeeCounter++, names[random.nextInt(10)], surnames[random.nextInt(10)], age, salary * salaryIndex );
            
        }else if (type==1){
            return new Freelancer(employeeCounter++, names[random.nextInt(10)], surnames[random.nextInt(10)], age, salary);
            
        }else{
            return new Podsobnik(employeeCounter++, names[random.nextInt(10)], surnames[random.nextInt(10)], age, salary);
            
        }

    }

    public static void main(String[] args) {

        Employee[] employees = new Employee[20];
        for (int i = 0; i < employees.length; i++){
            employees[i] = generateEmployee();
        }
        System.out.println("\nИсходный список сотрудников:");
        for (Employee employee: employees) {
            System.out.println(employee);
        }

        Arrays.sort(employees);

        System.out.println("\nСортировка по ЗП:");

        for (Employee employee: employees) {
            System.out.println(employee);
        }
         Arrays.sort(employees, new SurNameComparator());
         System.out.println("\nСортировка по ФИО:");

         for (Employee employee: employees) {
             System.out.println(employee);
         }

         Arrays.sort(employees, new AgeComparator());
         System.out.println("\nСортировка по возрасту:");

         for (Employee employee: employees) {
             System.out.println(employee);
         }
    }

}

class SalaryComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {

        return Double.compare(o2.calculateSalary(), o1.calculateSalary());

    }
}

class SurNameComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {

        return o1.surName.compareTo(o2.surName);
    }

}

class AgeComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {

        return Double.compare(o1.age, o2.age);

    }

}

abstract class Employee implements Comparable<Employee>{

    protected int id;
    protected int age;
    protected String firstName;
    protected String surName;
    protected double salary;
    
    public Employee(String firstName, String surName, double salary, int age) {
        this.firstName = firstName;
        this.surName = surName;
        this.salary = salary;
        this.age = age;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return String.format("Сотрудник: %s %s; Возраст: %d; Ставка: %.2f; Среднемесячная заработная плата: %.2f",
                surName, firstName, age, salary, calculateSalary());
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(calculateSalary(), o.calculateSalary());
    }
}

class Worker extends Employee{

    public Worker(int id, String firstName, String surName, int age, double salary) {
        super(firstName, surName, salary, age);
        this.id = id;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%d. %s %s; Сотрудник в офисе; возраст %d лет; Среднемесячная ЗП: %.0f",
                id, surName, firstName, age, calculateSalary());
    }
}

class Freelancer extends Employee{

    public Freelancer(int id, String firstName, String surName, int age, double salary) {
        super(firstName, surName, salary, age);
        this.id = id;
    }

    @Override
    public double calculateSalary() {
        return salary * 18 * 5 * 1.0;
    }

    @Override
    public String toString() {
        return String.format("%d. %s %s; Фрилансер; возраст %d лет; Среднемесячная ЗП: %.0f",
                id, surName, firstName, age, calculateSalary());
    }
}

class Podsobnik extends Employee{

    public Podsobnik(int id, String firstName, String surName, int age, double salary) {
        super(firstName, surName, salary, age);
        this.id = id;
    }

    @Override
    public double calculateSalary() {
        // return salary * 18 * 5 * 0.3;
        return 27000;
    }

    @Override
    public String toString() {
        return String.format("%d. %s %s; Подсобный рабочий; возраст %d лет; Фикс. оклад: %.0f",
                id, surName, firstName, age, calculateSalary());
    }
}

