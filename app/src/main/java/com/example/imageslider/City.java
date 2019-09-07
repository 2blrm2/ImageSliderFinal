package com.example.imageslider;

import java.util.ArrayList;

public class City {
    private String name;
    private ArrayList<String> imageUrls;

    public City(String name, ArrayList<String> imageUrls) {
        this.name = name;
        this.imageUrls = imageUrls;
    }

    public City() {
        imageUrls = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(ArrayList<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", imageUrls=" + imageUrls +
                '}';
    }
}
