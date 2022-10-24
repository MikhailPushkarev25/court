package ru.admin.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee")
@Data
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String address;
    @ManyToOne
    private Court court;
    @ManyToOne
    private Position position;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
