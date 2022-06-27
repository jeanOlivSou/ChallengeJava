package io.github.jeanolivsou.ChallengeJava.domains;

import lombok.Getter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Order {

    @NotNull
    private Long order_id;

    private Double total;

    @Past
    private LocalDate date;

    private List<Product> products;

    public Order(Long order_id, LocalDate date){
        this.order_id = order_id;
        this.total = 0.0;
        this.date = date;
        this.products = new ArrayList<>();
    }

    public void setTotal(Product product) {
        products.add(product);
        products.sort((p1, p2)-> p1.compare(p1, p2));
        this.total += product.getValue();
    }
}
