package shipping;

import java.util.*;
import java.util.stream.Collectors;

public class ShippingService {

    private List<Transportable> packages = new ArrayList<>();

    public void addPackage(Transportable transportable) {
        packages.add(transportable);
    }

    public List<Transportable> getPackages() {
        return new ArrayList<>(packages);
    }

    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight) {
        return packages.stream()
                .filter(packages -> packages.isBreakable() == breakable)
                .filter(packages -> packages.getWeight() >= weight)
                .toList();

//        List<Transportable> result = new ArrayList<>();
//        for (Transportable actual : packages) {
//            if (actual.getWeight() >= weight && actual.isBreakable() == breakable) {
//                result.add(actual);
//            }
//        }
//        return result;
    }

    public List<Transportable> sortInternationalPackagesByDistance() {
        return new ArrayList<>(packages.stream()
                .filter(packages -> !packages.getDestinationCountry().equals(Transportable.DESTINATION_COUNTRY))
                .sorted(Comparator.comparingInt(packages -> ((InternationalPackage) packages).getDistance()))      // .map(pack -> ((InternationalPackage)pack))
                .toList());                                                                                        // .sorted(Comparator.comparingInt(InternationalPackage::getDistance))
    }

    public Map<String, Integer> collectTransportableByCountry() {
        return packages.stream()
                .collect(Collectors.toMap(Transportable::getDestinationCountry, packages -> 1, Integer::sum));

//        Map<String, Integer> result = new HashMap<>();
//        for (Transportable actual: packages) {
//            String key = actual.getDestinationCountry();
//            if (!result.containsKey(key)) {
//                result.put(key, 1);
//            } else {
//                result.put(key, result.get(key) + 1);
//            }
//        }
//        return result;
    }
}
