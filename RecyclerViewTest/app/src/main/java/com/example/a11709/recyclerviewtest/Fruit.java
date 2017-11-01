package com.example.a11709.recyclerviewtest;

public class Fruit {
    private String name;
    private int imageId;
    public Fruit(String name,int imageId){
        this.imageId=imageId;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
