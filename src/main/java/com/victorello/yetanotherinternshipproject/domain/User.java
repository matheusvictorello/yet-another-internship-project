package com.victorello.yetanotherinternshipproject.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="User_")
@NoArgsConstructor
public class User extends AbstractEntity {

    @NotNull
    @NotEmpty
    @Column(unique = true)
    @Getter
    @Setter
    private String name;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Set<Project> projectSet = new HashSet<>();

    public User(String name) {
        this.name = name;
    }
}
