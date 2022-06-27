package io.github.jeanolivsou.ChallengeJava.services;

import io.github.jeanolivsou.ChallengeJava.domains.Order;
import io.github.jeanolivsou.ChallengeJava.domains.Product;
import io.github.jeanolivsou.ChallengeJava.domains.User;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class FileToObjectService {
    private Map<Long, User> users;

    public FileToObjectService(){
        this.users = new TreeMap<>();
    }

    public void ReadLine(String[] splitList) {
        Long user_id = Long.parseLong(splitList[1]);
        String name = splitList[2];
        Long order_id = Long.parseLong(splitList[3]);
        Long product_id = Long.parseLong(splitList[4]);
        Double value = Double.parseDouble(splitList[5].substring(0, (splitList[5].length() - 8)));
        String dateStr = splitList[5].substring((splitList[5].length() - 8));
        LocalDate date = LocalDate.parse(DateFormatter(dateStr));

        Product product = new Product(product_id, value);
        Order order = new Order(order_id, date);
        User user = new User(user_id, name);

        User userMap = containsUsersMap(user);
        Order orderMap = containsOrdersMap(user, order);
        orderMap.setTotal(product);

        users.put(userMap.getUser_id(), userMap);
    }

    private String DateFormatter(String date){
        StringBuilder dateFormat = new StringBuilder(date);
        dateFormat.insert(4, "-");
        dateFormat.insert(date.length() - 1, "-");

        return dateFormat.toString();
    }

    private Order addOrderMap(User user, Order order){
        user.getOrders().put(order.getOrder_id(), order);
        return user.getOrders().get(order.getOrder_id());
    }

    private User addUsersMap(User user){
        users.put(user.getUser_id(), user);
        return users.get(user.getUser_id());
    }

    private User containsUsersMap(User user){
        if (users.containsKey(user.getUser_id())){
            return users.get(user.getUser_id());
        }
        else {
            return addUsersMap(user);
        }
    }

    private Order containsOrdersMap(User user, Order order){
        if (user.getOrders().containsKey(order.getOrder_id())){
            return user.getOrders().get(order.getOrder_id());
        }
        else {
            return addOrderMap(user, order);
        }
    }
}
