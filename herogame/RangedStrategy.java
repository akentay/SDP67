package herogame;

public class RangedStrategy implements AttackStrategy {
    @Override
    public int attack(Hero target) {
        int dmg = (int)(Math.random() * 15) + 15;
        return dmg;
    }

    @Override
    public String getName() { return "Ranged"; }
}
