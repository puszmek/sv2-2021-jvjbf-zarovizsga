package shipping;

import java.util.*;

public class ShippingService {

    private List<Transportable> packages = new ArrayList<>();

    public void addPackage(Transportable transportable) {
        packages.add(transportable);
    }

    public List<Transportable> getPackages() {
        return packages;
    }

    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight) {
        List<Transportable> result = new ArrayList<>();
        for (Transportable actual : packages) {
            if (actual.getWeight() >= weight && actual.isBreakable() == breakable) {
                result.add(actual);
            }
        }
        return result;
    }

    public List<Transportable> sortInternationalPackagesByDistance() {
        return packages.stream()
                .filter(transportable -> transportable instanceof InternationalPackage)
                .sorted(Comparator.comparing(p -> ((InternationalPackage) p).getDistance()))
                .toList();
    }

    public Map<String, Integer> collectTransportableByCountry() {
        Map<String, Integer> result = new LinkedHashMap<>();
        for (Transportable transportable : packages) {

        }
        return result;
    }
}
