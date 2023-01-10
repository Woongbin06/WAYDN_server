package com.WAYDN.waydn.condition.domain.user.domain;

import com.WAYDN.waydn.condition.domain.condition.Condition;
import com.WAYDN.waydn.condition.domain.user.domain.type.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String email;

    private int classNumber; // 학번

    @Column(name = "username")
    private String name;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    public User(String email, int classNumber, String name, String password) {
        this.email = email;
        this.classNumber = classNumber;
        this.name = name;
        this.password = password;
    }

    @OneToMany(cascade = ALL, mappedBy = "writer")
    private List<Condition> conditions = new ArrayList<>();

    public void addConditions(Condition condition) {
        this.conditions.add(condition);
    }
}
