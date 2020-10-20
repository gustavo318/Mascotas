package com.jgmayer.mascotas;

public class PetModel {
    private int image;
    private String name;
    private int rating;

    public PetModel(int image, String name, int rating) {
        this.image = image;
        this.name = name;
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setFavorite() {
    }
}
