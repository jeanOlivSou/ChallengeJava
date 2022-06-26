package io.github.jeanolivsou.ChallengeJava.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @NotNull
    private Long product_id;

    @Digits(integer = 10, fraction = 2)
    private BigDecimal value;
}
