package hero;

public class Main {
    public static void main(String[] args) {

        Hero hero = new Hero("John", 20);

        DarkKnight darkKnight = new DarkKnight("Gordon", 30);

        MuseElf museElf = new MuseElf("Elf", 5);

        System.out.println(hero);

        System.out.println(darkKnight);

        System.out.println(museElf);

    }
}