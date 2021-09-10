package circus.animal;

import circus.Asset;

import java.util.Comparator;

public abstract class Animal implements Asset {

    public String name;
    public abstract String speak();

    public static Comparator<Animal> compareAnimal = new Comparator<>(){
        @Override
        public int compare (Animal animal1, Animal animal2){
            return animal1.name.toLowerCase().compareTo(animal2.name.toLowerCase());
        }
    };

    //public static Comparator<Animal> compareAnimal = Comparator.comparing(o -> o.name.toLowerCase());
}
