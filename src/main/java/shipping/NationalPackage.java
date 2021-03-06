package shipping;

public class NationalPackage implements Transportable {

    private static final int SHIPPING_PRICE = 1000;

    private int weight;
    private boolean breakable;

    public NationalPackage(int weight, boolean breakable) {
        this.weight = weight;
        this.breakable = breakable;
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
    public int calculateShippingPrice() {
        if (breakable) {
            return 2 * SHIPPING_PRICE;
        } else {
            return SHIPPING_PRICE;
        }

        // return isBreakable ? SHIPPING_PRICE * 2 : SHIPPING_PRICE;
    }

}
