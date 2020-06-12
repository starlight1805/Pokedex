package com.example.pokedex;

public class Pokemon {
    private String name;
    private int image;
    public Pokemon(String type, int image) {
        this.name = type;
        this.image = image;
    }
    public String getName() {
        return name;
    }
    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setImage(int image) {
        this.image = image;
    }
}
