package herogame;

import java.util.*;

public abstract class Hero {
    protected String name;
    protected int health = 100;
    protected AttackStrategy strategy;
    private final List<HeroObserver> observers = new ArrayList<>();

    public Hero(String name) {
        this.name = name;
        this.strategy = new MeleeStrategy();
    }

    public String getName() { return name; }
    public boolean isAlive() { return health > 0; }
    public int getHealth() { return health; }

    public void attack(Hero target) {
        if (!isAlive()) return;
        int damage = strategy.attack(target);
        target.takeDamage(damage);
        notifyObservers(name + " attacked " + target.getName() + " for " + damage + " dmg!");
    }

    public void takeDamage(int dmg) {
        health -= dmg;
        if (health <= 0) {
            health = 0;
            notifyObservers(name + " has fallen 💀");
        } else {
            notifyObservers(name + " now has " + health + " HP");
        }
    }

    public void setStrategy(AttackStrategy s) {
        this.strategy = s;
        notifyObservers(name + " switched strategy to " + s.getName());
    }

    public void registerObserver(HeroObserver obs) { observers.add(obs); }
    public void notifyObservers(String msg) { for (HeroObserver o : observers) o.update(msg); }

    @Override
    public String toString() {
        return name + " (" + getClass().getSimpleName() + ") - HP: " + health;
    }
}
