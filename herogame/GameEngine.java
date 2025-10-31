package herogame;

import java.util.*;

public class GameEngine {
    private static GameEngine instance;
    private final List<Hero> heroes = new ArrayList<>();

    private GameEngine() {}

    public static GameEngine getInstance() {
        if (instance == null) instance = new GameEngine();
        return instance;
    }

    public void addHero(Hero h) { heroes.add(h); }

    public List<Hero> getAliveHeroes() {
        List<Hero> alive = new ArrayList<>();
        for (Hero h : heroes) if (h.isAlive()) alive.add(h);
        return alive;
    }

    public void runRound() {
        List<Hero> alive = getAliveHeroes();
        if (alive.size() < 2) return;
        System.out.println("\nNew Round AAA!");

        for (Hero attacker : alive) {
            if (!attacker.isAlive()) continue;
            Hero target = null;
            do {
                target = alive.get((int)(Math.random() * alive.size()));
            } while (target == attacker || !target.isAlive());

            attacker.attack(target);
        }
    }
}
