package com.codegym.cms.model;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@Table(name="Blog")
@NamedQueries({@NamedQuery(name="findAll", query = "select c from User c"),
        @NamedQuery(name = "findById", query = "select c from User c where c.id=:id")})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String type;


    public User() {
    }

    public User(String name, String email, String type) {
        this.name = name;
        this.email = email;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
