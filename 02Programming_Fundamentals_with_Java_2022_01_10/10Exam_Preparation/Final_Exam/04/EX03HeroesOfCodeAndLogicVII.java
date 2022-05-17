package EX04FinalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class EX03HeroesOfCodeAndLogicVII {

    static class Hero {
        String name;
        int hitPoints;
        int manaPoints;

        public Hero(String name, int hitPoints, int manaPoints) {
            this.name = name;
            this.hitPoints = hitPoints;
            this.manaPoints = manaPoints;
        }

        public String getName() {
            return this.name;
        }

        public int getHitPoints() {
            return this.hitPoints;
        }

        public void setHitPoints(int hitPoints) {
            this.hitPoints = hitPoints;
        }

        public int getManaPoints() {
            return this.manaPoints;
        }

        public void setManaPoints(int manaPoints) {
            this.manaPoints = manaPoints;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int heroesNumber = Integer.parseInt(scanner.nextLine());

        Map<String, Hero> heroes = new LinkedHashMap<>();

        for (int i = 1; i <= heroesNumber; i++) {
            String[] heroParams = scanner.nextLine().split(" ");
            String heroName = heroParams[0];
            int HP = Integer.parseInt(heroParams[1]);
            int MP = Integer.parseInt(heroParams[2]);
            Hero hero = new Hero(heroName, HP, MP);
            heroes.put(heroName, hero);
        }

        String inputCommand = scanner.nextLine();

        while (!inputCommand.equals("End")) {
            String[] commandParams = inputCommand.split(" - ");
            String command = commandParams[0];
            switch (command) {
                case "CastSpell":
                    castSpell(heroes, commandParams[1], Integer.parseInt(commandParams[2]), commandParams[3]);
                    break;
                case "TakeDamage":
                    takeDamage(heroes, commandParams[1], Integer.parseInt(commandParams[2]), commandParams[3]);
                    break;
                case "Recharge":
                    recharge(heroes, commandParams[1], Integer.parseInt(commandParams[2]));
                    break;
                case "Heal":
                    heal(heroes, commandParams[1], Integer.parseInt(commandParams[2]));
                    break;
            }

            inputCommand = scanner.nextLine();
        }

        for (Hero h : heroes.values()) {
            System.out.printf("%s%n  HP: %d%n  MP: %d%n", h.getName(), h.getHitPoints(), h.getManaPoints());
        }

    }

    private static void castSpell(Map<String, Hero> heroes, String heroName, int MPNeeded, String spellName) {
        int heroMP = heroes.get(heroName).getManaPoints();
        if (heroMP >= MPNeeded) {
            heroMP -= MPNeeded;
            heroes.get(heroName).setManaPoints(heroMP);
            System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, heroMP);
        } else {
            System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
        }
    }

    private static void takeDamage(Map<String, Hero> heroes, String heroName, int damage, String attacker) {
        int heroHP = heroes.get(heroName).getHitPoints();
        heroHP -= damage;
        if (heroHP > 0) {
            heroes.get(heroName).setHitPoints(heroHP);
            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, heroHP);
        } else {
            heroes.remove(heroName);
            System.out.printf("%s has been killed by %s!%n", heroName, attacker);
        }
    }

    private static void recharge(Map<String, Hero> heroes, String heroName, int amount) {
        int heroMP = heroes.get(heroName).getManaPoints();
        int rechargeMP = amount;
        if (heroMP + amount > 200) {
            rechargeMP = 200 - heroMP;
        }
        heroMP += rechargeMP;
        heroes.get(heroName).setManaPoints(heroMP);
        System.out.printf("%s recharged for %d MP!%n", heroName, rechargeMP);
    }

    private static void heal(Map<String, Hero> heroes, String heroName, int amount) {
        int heroHP = heroes.get(heroName).getHitPoints();
        int rechargeHP = amount;
        if (heroHP + amount > 100) {
            rechargeHP = 100 - heroHP;
        }
        heroHP += rechargeHP;
        heroes.get(heroName).setHitPoints(heroHP);
        System.out.printf("%s healed for %d HP!%n", heroName, rechargeHP);
    }

}