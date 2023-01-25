package aquarium;

public class Main {
    public static void main(String[] args) {
        Fish f = new Fish("name");
        Fish f1 = new Fish("name1");
        Fish f2 = new Fish("name2");
        Aquarium aquarium = new Aquarium("aqua", 10);

        aquarium.add(f);
        aquarium.add(f1);
        aquarium.add(f2);
        aquarium.remove("name2");
        System.out.println(aquarium.report());
    }
}
