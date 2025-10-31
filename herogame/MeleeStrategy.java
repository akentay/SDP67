package herogame;

public class MeleeStrategy implements AttackStrategy {
    @Override
    public int attack(Hero target) {
        int dmg = (int)(Math.random() * 20) + 10;
        return dmg;
    }

    @Override
    public String getName() { return "Melee"; }
}
