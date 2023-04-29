package softuni.bg.L01SpringMVC.model;

public class Dog {

    private String name;

    private int age;

    private String breed;

    public Dog() {
    }

    public String getName() {
        return name;
    }

    public Dog setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Dog setAge(int age) {
        this.age = age;
        return this;
    }

    public String getBreed() {
        return breed;
    }

    public Dog setBreed(String breed) {
        this.breed = breed;
        return this;
    }

}