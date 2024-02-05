package Valuator;

/**
 *
 * @author ondre
 */
public class State {

    private final String name;
    private final double growth;

    /**
     *
     * @param name
     * @param growth
     */
    public State(String name, double growth) {
        this.name = name;
        this.growth = growth;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public double getGrowth() {
        return growth;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return name;
    }

}
