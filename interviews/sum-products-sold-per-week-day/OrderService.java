import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Return the number of sold products per week day
 */

public class OrderService {

    public static Map<DayOfWeek, Integer> sumOfProductsSoldPerWeekDay(List<Order> orders, Integer productId) {
        Map<DayOfWeek, Integer> map = new HashMap<>();

        for (Order o : orders) {
            Integer sum = o.getProducts()
                    .stream()
                    .filter(p -> p.getProductId() == productId)
                    .mapToInt(p -> p.getQuantity())
                    .sum();

            updateMap(map, o.getOrderDate().getDayOfWeek(), sum);
        }

        return map;
    }

    private static void updateMap(Map<DayOfWeek, Integer> map, DayOfWeek day, Integer sum) {
        if (map.containsKey(day)) {
            Integer actualSum = map.get(day);
            map.put(day, Integer.sum(actualSum, sum));
        } else {
            map.put(day, sum);
        }
    }

    public static void main(String[] args) {
        Product p1 = new Product(1, 2, "p1");
        Product p2 = new Product(2, 1, "p2");
        Product p3 = new Product(3, 2, "p3");
        Product p4 = new Product(4, 3, "p4");
        Product p5 = new Product(5, 1, "p5");
        Product p6 = new Product(6, 1, "p6");
        Product p7 = new Product(7, 2, "p7");

        List<Product> products1 = Arrays.asList(p2, p3, p4, p5, p6, p7, p4);
        List<Product> products2 = Arrays.asList(p1, p2, p5, p6, p7);
        List<Product> products3 = Arrays.asList(p1, p2, p3, p4, p5, p7, p3, p4);
        List<Product> products4 = Arrays.asList(p1, p3, p4, p5, p3);

        Order o1 = new Order(1, LocalDateTime.parse("2018-11-27T00:00:00"), products1);
        Order o2 = new Order(2, LocalDateTime.parse("2018-11-28T00:00:00"), products2);
        Order o3 = new Order(3, LocalDateTime.parse("2018-11-29T00:00:00"), products3);
        Order o4 = new Order(4, LocalDateTime.parse("2018-11-30T00:00:00"), products4);

        Map<DayOfWeek, Integer> weekDaySum = sumOfProductsSoldPerWeekDay(Arrays.asList(o1, o2, o3, o4), 3);

        weekDaySum.forEach((k, v) -> {
            System.out.println("key: " + k + " - value: " + v);
        });
    }

}
