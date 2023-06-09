package Valuator;
/**
 *
 * @author ondre
 */
public class State {
    private final String name;
    private final double growth;

    public State(String name, double growth) {
        this.name = name;
        this.growth = growth;
    }

    public String getName() {
        return name;
    }

    public double getGrowth() {
        return growth;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
