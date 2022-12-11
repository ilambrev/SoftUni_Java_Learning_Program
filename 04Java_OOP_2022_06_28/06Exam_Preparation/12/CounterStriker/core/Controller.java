package CounterStriker.core;

public interface Controller {
    String addGun(String type, String name, int bulletsCount);

    String addPlayer(String type, String username, int health, int armor, String gunName);

    String startGame();

    String report();
}
