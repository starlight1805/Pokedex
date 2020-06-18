package com.example.pokedex;

public class typesofpokemon {
    private String name;
    private String url;
    private int number;

    public typesofpokemon(String name, String url) {
        this.url = url;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getURL() {
        return url;
    }

    public int getNumber() {
        String[] urls = url.split("/");
        return (Integer.parseInt(urls[(urls.length) - 1]));
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String url) {
        this.url = url;
    }
}