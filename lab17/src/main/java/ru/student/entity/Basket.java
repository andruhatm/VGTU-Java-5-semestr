package ru.student.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "basket")
@NoArgsConstructor
@Getter
@Setter
@NamedQuery(name = "getAll", query = "SELECT b from Basket b")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String name;

    @Column
    String path;

    public Basket(String name, String path) {
        this.name = name;
        this.path = path;
    }
}
