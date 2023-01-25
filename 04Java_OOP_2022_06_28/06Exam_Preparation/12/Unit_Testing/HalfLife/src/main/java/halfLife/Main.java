package halfLife;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Hunter", 100);

        Gun gun1 = new Gun("Makarov", 12);
        Gun gun2 = new Gun("Remington ", 50);
        Gun gun3 = new Gun("Glock ", 10);

        player.addGun(gun1);
        player.addGun(gun2);
        player.addGun(gun3);
    }
}
