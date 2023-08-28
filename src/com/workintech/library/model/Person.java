package com.workintech.library.model;

import com.workintech.library.helper.Role;

import java.util.Objects;

public abstract class Person {

    private int id;
    private String name;
    private Role role;

    public Person(int id, String name, Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract Role whoYouAre();

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("--------PERSON--------\n");
        builder.append("Person ID: " + getId() + "\n");
        builder.append("Name: " + getName() + "\n");
        builder.append("--------------------\n");
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
