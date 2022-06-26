package io.github.jeanolivsou.ChallengeJava.domains;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class User {
    @NotNull
    private Long user_id;

    @Size(max = 45)
    private String name;
    private List<Order> orders;
}
