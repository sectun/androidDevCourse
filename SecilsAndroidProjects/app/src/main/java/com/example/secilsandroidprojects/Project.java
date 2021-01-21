package com.example.secilsandroidprojects;

public class Project {

    String name;
    String description;
    int image;

    // R.drawable.name_of_the_file (this will be some sort of number, an 'int')

    Project(String name, String description, int image){
        this.name = name;
        this.description = description;
        this.image = image;
    }
}
