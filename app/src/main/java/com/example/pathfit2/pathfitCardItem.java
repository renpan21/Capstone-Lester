package com.example.pathfit2;

public class pathfitCardItem {
    String title;
    String description;
    String topic; // Different content for expandable section
    int imageResource; // Different image for expandable section
    boolean isExpanded;

    // Constructor
    public pathfitCardItem(String title, String description, String additionalInfo, int imageResource) {
        this.title = title;
        this.description = description;
        this.topic = additionalInfo;
        this.imageResource = imageResource;
        this.isExpanded = false;
    }


}