package circus;


import circus.animal.*;
import circus.stuff.Cage;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        System.out.println("Numbers of animals: " + animals.length);
        makeAnimalsTalk();
        /*
        System.out.println("Total value of animals " + calculateAssetValue(animals));
        System.out.println("Total value of equipments " + calculateAssetValue(equipments));
        */
        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));
        animalArrayList.add(new Parrot("Dolly"));
        animalArrayList.add(new Duck("Shaki"));
        printAllAnimals(animalArrayList);
        Elephant phillip = new Elephant("Phillip");
        animalArrayList.add(phillip);
        String name = "Phillip";
        System.out.println("Index of " + name + ": " + animalArrayList.indexOf(phillip));
        animalArrayList.sort(Animal.compareAnimal);
        System.out.println("After sorting ...");
        printAllAnimals(animalArrayList);

        System.out.println("Number of animals: " + animals.length);
        System.out.println("Number of animals: " + animalArrayList.size());
        animalArrayList.add(new Tiger("Sherkhan"));
        System.out.println("Number of animals: " + animalArrayList.size());

        animalArrayList.add(new Parrot("Patrick"));

        Duck louie = new Duck("Louie");
        animalArrayList.add(louie);
        Elephant strongOne = new Elephant("StrongOne");
        animalArrayList.add(strongOne);

        printAllAnimals(animalArrayList);

        Cage<Duck> duckCage = new Cage<>();
        Duck duck = new Duck("Donald");
        duckCage.lockUp(duck);
        Parrot parrot = new Parrot("Patrol");
        Cage<Parrot> parrotCage = new Cage<>();
        parrotCage.lockUp(parrot);
        Cage<Elephant> elpCage = new Cage<>();
        elpCage.lockUp(strongOne);
        ArrayList<Cage> cages = new ArrayList<>();
        cages.add(duckCage);
        cages.add(parrotCage);

        for(Cage c: cages) {
            c.release();
        }
    }
}
