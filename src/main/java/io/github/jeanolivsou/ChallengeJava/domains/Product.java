package io.github.jeanolivsou.ChallengeJava.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Comparator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Comparator<Product> {
    @NotNull
    private Long product_id;

    private Double value;

    @Override
    public int compare(Product product1, Product product2) {
        return (int) (product1.getProduct_id() - product2.getProduct_id());
    }
}
