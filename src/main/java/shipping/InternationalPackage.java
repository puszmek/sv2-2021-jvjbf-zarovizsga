package shipping;

public class InternationalPackage implements Transportable {

    private static final int SHIPPING_PRICE = 1200;
    private static final int PRICE_PER_KM = 10;

    private int weight;
    private boolean breakable;
    private String destinationCountry;
    private int distance;

    public InternationalPackage(int weight, boolean breakable, String destinationCountry, int distance) {
        this.weight = weight;
        this.breakable = breakable;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public String getDestinationCountry() {
        return destinationCountry;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int calculateShippingPrice() {
        if (breakable) {
            return 2 * SHIPPING_PRICE + distance * PRICE_PER_KM;
        } else {
            return SHIPPING_PRICE + distance * PRICE_PER_KM;
        }
    }
}
