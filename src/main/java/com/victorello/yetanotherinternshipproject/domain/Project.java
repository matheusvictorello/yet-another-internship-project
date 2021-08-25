package com.victorello.yetanotherinternshipproject.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Project extends AbstractEntity {

    @NotNull
    @NotEmpty
    @Getter
    @Setter
    private String name;

    @NotNull
    @ManyToOne
    @Getter
    @Setter
    private User owner;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Set<Task> taskSet = new HashSet<>();

    public Project(String name, User owner) {
        this.name = name;
        this.owner = owner;
    }
}
