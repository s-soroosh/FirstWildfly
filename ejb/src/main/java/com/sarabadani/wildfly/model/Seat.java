package com.sarabadani.wildfly.model;

import java.io.Serializable;

/**
 * Created by soroosh on 9/6/14.
 */
public class Seat implements Serializable {
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    private final Integer id;
    private final String name;
    private final Integer price;
    private boolean reserved;

    public Seat(Integer id, String name, Integer price) {

        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void reserve() {
        if (this.reserved) {
            throw new RuntimeException("Seat is reserved before!");
        }
        this.reserved = true;
    }
}
