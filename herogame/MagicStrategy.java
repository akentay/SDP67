package herogame;

public class MagicStrategy implements AttackStrategy {
    @Override
    public int attack(Hero target) {
        int dmg = (int)(Math.random() * 25) + 5;
        return dmg;
    }

    @Override
    public String getName() { return "Magic"; }
}
