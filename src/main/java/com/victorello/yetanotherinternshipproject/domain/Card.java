package com.victorello.yetanotherinternshipproject.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
public class Card extends AbstractEntity {

    @NotNull
    @NotEmpty
    @Getter
    @Setter
    private String name;

    @NotNull
    @ManyToOne
    @Getter
    @Setter
    private Task task;

    public Card(String name, Task task) {
        this.name = name;
        this.task = task;
    }
}
