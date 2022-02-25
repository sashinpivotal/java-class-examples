package com.example.monster2;

public class FireMonster extends Monster {

    public FireMonster(String name) {
//        super.name = name;
      super(name);
    }

    @Override
    public String attack() {
        return getName() + "attack with fire";
    }
}
