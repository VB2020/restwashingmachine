package com.example.restwashingmachine.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity // сущность, которую и сохраняем в БД
@Table (name = "machines")
@Getter
@Setter
public class WashingMachine {

    @Id // идентификатор
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "machine_name")
    private String machine_name;

    public WashingMachine() {
        // конструктор без параметров должен быть так как этот класс - Entity!
    }

    public WashingMachine(String param) {
        machine_name = param;
    }
}
