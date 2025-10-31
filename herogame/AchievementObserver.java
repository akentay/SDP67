package herogame;

public class AchievementObserver implements GameObserver {
    @Override
    public void onAttack(String attacker, String target, int damage) {
        if (damage >= 30) {
            System.out.println("[ACHIEVEMENT] " + attacker + " unlocked 'Devastator' (>=30 dmg)!");
        }
    }

    @Override
    public void onHealthChanged(String heroName, int newHealth) {
        if (newHealth > 0 && newHealth <= 20) {
            System.out.println("[ACHIEVEMENT] " + heroName + " is 'On the Edge' (low HP).");
        }
    }

    @Override
    public void onHeroDeath(String heroName) {
        System.out.println("[ACHIEVEMENT] " + heroName + " gained 'Fallen' entry in the battle log.");
    }
}
