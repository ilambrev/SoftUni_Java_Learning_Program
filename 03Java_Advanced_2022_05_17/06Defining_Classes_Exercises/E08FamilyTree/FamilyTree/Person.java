package FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public String name;
    public String birthDate;
    public List<Person> parents;
    public List<Person> children;

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<Person> getParents() {
        return this.parents;
    }

    public List<Person> getChildren() {
        return this.children;
    }


    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.birthDate);
    }

}