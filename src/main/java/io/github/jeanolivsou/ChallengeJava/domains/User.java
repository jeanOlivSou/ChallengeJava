package io.github.jeanolivsou.ChallengeJava.domains;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;
import java.util.TreeMap;

@Getter
public class User {
    @NotNull
    private Long user_id;

    @Size(max = 45)
    private String name;

    private Map<Long, Order> orders;

    public User(Long user_id, String name){
        this.user_id = user_id;
        this.name = name;
        this.orders = new TreeMap<>();
    }
}
