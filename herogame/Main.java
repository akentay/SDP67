package herogame;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to hero battle game!");

        System.out.print("Enter your name: ");
        String playerName = sc.nextLine();

        System.out.println("Choose your hero:");
        System.out.println("1. Warrior");
        System.out.println("2. Mage");
        System.out.println("3. Archer");
        System.out.print("> ");
        int choice = sc.nextInt();
        sc.nextLine();

        Hero player = switch (choice) {
            case 1 -> new Warrior(playerName);
            case 2 -> new Mage(playerName);
            case 3 -> new Archer(playerName);
            default -> new Warrior(playerName);
        };

        System.out.println("\nChoose your attack strategy:");
        System.out.println("1. Melee");
        System.out.println("2. Ranged");
        System.out.println("3. Magic");
        System.out.print("> ");
        int strat = sc.nextInt();
        sc.nextLine();

        switch (strat) {
            case 1 -> player.setStrategy(new MeleeStrategy());
            case 2 -> player.setStrategy(new RangedStrategy());
            case 3 -> player.setStrategy(new MagicStrategy());
            default -> player.setStrategy(new MeleeStrategy());
        }

        // Create AI heroes
        Hero bot1 = new Warrior("Orion");
        Hero bot2 = new Mage("Luna");
        Hero bot3 = new Archer("Rex");

        bot1.setStrategy(new RangedStrategy());
        bot2.setStrategy(new MagicStrategy());
        bot3.setStrategy(new MeleeStrategy());

        // Register observers
        ConsoleLogger logger = new ConsoleLogger();
        player.registerObserver(logger);
        bot1.registerObserver(logger);
        bot2.registerObserver(logger);
        bot3.registerObserver(logger);

        GameEngine engine = GameEngine.getInstance();
        engine.addHero(player);
        engine.addHero(bot1);
        engine.addHero(bot2);
        engine.addHero(bot3);

        System.out.println("\nThe battle starts AAA!");

        while (engine.getAliveHeroes().size() > 1) {
            engine.runRound();
            Thread.sleep(800);
        }

        Hero winner = engine.getAliveHeroes().get(0);
        System.out.println("\n THE WINNER IS: " + winner.getName());
        System.out.println("Game Over!");
    }
}
