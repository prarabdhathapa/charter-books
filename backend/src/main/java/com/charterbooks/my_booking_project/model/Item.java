package com.charterbooks.my_booking_project.model;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String description;
    private Double price;
    private String timeSlot;
    private boolean enabled = true;

    public Item() {}


    public Item(String name, String type, String description, Double price, String timeSlot, boolean enabled){
        this.name = name;
        this.type = type;
        this.description = description;
        this.price = price;
        this.timeSlot = timeSlot;
        this.enabled = enabled;

    }

    //getters and setters
    public Long getId() {return id;}
    public void setId(Long id){this.id = id;}

    public String getName() {return name;}
    public void setName(String name){ this.name = name; }

    public String getType() {return type;}
    public void setType(String type){ this.type = type; }

    public String getDescription(){return description;}
    public void setDescription(String description){this.description = description;}

    public double getPrice(){return price; }
    public void setPrice(double price) {this.price = price;}

    public String getTimeSlot() { return timeSlot; }
    public void setTimeSlot(String timeSlot) {this.timeSlot = timeSlot;}

    public boolean isEnabled() {return enabled;}
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
}
