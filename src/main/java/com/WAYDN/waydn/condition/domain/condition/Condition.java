package com.WAYDN.waydn.condition.domain.condition;

import com.WAYDN.waydn.condition.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Conditions")
@Getter
@NoArgsConstructor
public class Condition extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "condition_id")
    private long id;

    @Column(length = 20, nullable = false)
    private String content;

    @Builder
    public Condition(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name = "user_id") // user의 PK명을 써줌.
    private User writer;

    public void confirmWriter(User user) {
        this.writer = user;
        user.addConditions(this);
    }

    public void update(String content) {
        this.content = content;
    }
}
