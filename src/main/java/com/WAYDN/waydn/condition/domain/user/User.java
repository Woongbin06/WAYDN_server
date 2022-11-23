package com.WAYDN.waydn.condition.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
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

    @Builder
    public User(String email, int classNumber, String name, String password) {
        this.email = email;
        this.classNumber = classNumber;
        this.name = name;
        this.password = password;
    }

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private final List<Condition> conditions = new ArrayList<>();*/
}
