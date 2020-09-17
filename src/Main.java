import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Dog dog2 = (Dog) deepCopy(dog);
    }

    public static Animal deepCopy(Animal a) {
        if (a instanceof Dog) {
            Dog dog = new Dog();
            dog.name = a.name;
            dog.map = new HashMap<>(((Dog) a).map);
            return dog;
        }else if (a instanceof Cat) {
            Cat cat = new Cat();
            cat.name = a.name;
            cat.list = new ArrayList<>(((Cat) a).list);
            return cat;
        }else {
            Animal b = new Animal();
            b.name = a.name;
            return b;
        }
    }

}
class Animal {
    String name;

}
class Dog extends Animal{
    HashMap<String,String> map;

}
class Cat extends Animal{
    ArrayList<String> list;
}