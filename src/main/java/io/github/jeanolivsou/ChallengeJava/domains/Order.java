package io.github.jeanolivsou.ChallengeJava.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @NotNull
    private Long order_id;

    @Digits(integer = 10, fraction = 2 )
    private BigDecimal total;

    @Past
    private LocalDate date;

    private List<Product> products;

}
