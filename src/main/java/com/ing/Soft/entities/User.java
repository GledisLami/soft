package com.ing.Soft.entities;

import javax.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "personal_no")
    private String personalNo;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "enabled")
    private Integer enabled;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    public User(Integer id) {
        this.id = id;
    }


    public User(Integer id, String username, String password, String name, String surname, String personalNo, Date birthday, Integer enabled, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.personalNo = personalNo;
        this.birthday = birthday;
        this.enabled = enabled;
        this.role = role;
    }

    public User() {
    }
}
