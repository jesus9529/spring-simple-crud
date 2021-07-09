package com.example.simplecrud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String surname;
    private String email;

    public User() {

    }

    protected User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    // Id setters and getter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Name setters and getter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Surname setters and getter

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Email setters and getter

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}