package shipping;

public interface Transportable {

    String DESTINATION_COUNTRY = "Hungary";

    public int getWeight();

    public boolean isBreakable();

    public int calculateShippingPrice();

    default String getDestinationCountry() {
        return DESTINATION_COUNTRY;
    }
}
