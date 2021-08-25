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
public class Task extends AbstractEntity {

    @NotNull
    @NotEmpty
    @Getter
    @Setter
    private String name;

    @NotNull
    @ManyToOne
    @Getter
    @Setter
    private Project project;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Set<Card> cardSet = new HashSet<>();

    public Task(String name, Project project) {
        this.name = name;
        this.project = project;
    }
}
