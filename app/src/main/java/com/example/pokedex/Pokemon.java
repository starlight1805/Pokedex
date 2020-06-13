package com.example.pokedex;

public class Pokemon {
    private String name;
    private int image;
    private Pokemon[] results;

    public Pokemon(String type, int image, Pokemon[] results) {
        this.name = type;
        this.image = image;
        this.results = results;
    }
    public String getName() {
        return name;
    }
    public int getImage() {
        return image;
    }
    public Pokemon[] getResults(){
        return results;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setImage(int image) {
        this.image = image;
    }
}
