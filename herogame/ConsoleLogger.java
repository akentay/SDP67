package herogame;

public class ConsoleLogger implements HeroObserver {
    @Override
    public void update(String message) {
        System.out.println("📢 " + message);
    }
}
