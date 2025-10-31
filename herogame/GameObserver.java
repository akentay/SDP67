package herogame;

/**
 * Observer pattern: receives notifications about hero events.
 */
public interface GameObserver {
    void onAttack(String attacker, String target, int damage);
    void onHealthChanged(String heroName, int newHealth);
    void onHeroDeath(String heroName);
}
