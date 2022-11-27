package com.WAYDN.waydn.condition.domain.condition;

import com.WAYDN.waydn.condition.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Condition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "condition_id")
    private long id;

    @Column(length = 20, nullable = false)
    private String content;

    @Builder
    public Condition(String content) {
        this.content = content;
    }

    @Builder
    public Condition(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
