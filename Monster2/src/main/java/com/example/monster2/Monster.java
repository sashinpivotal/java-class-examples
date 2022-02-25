package com.example.monster2;

public class Monster {

    public String getName() {
        return name;
    }

    protected String name;

    public Monster(String name) {
        this.name = name;
    }

    public Monster() {
    }

    public String attack() {
        return "default attack";
    }
}
