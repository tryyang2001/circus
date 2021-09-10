package circus;

import circus.animal.Animal;
import circus.animal.Duck;
import circus.animal.Elephant;
import circus.animal.Parrot;
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
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList){
            System.out.println(a);
        }
    }
}
