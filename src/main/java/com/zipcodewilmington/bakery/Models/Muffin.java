package com.zipcodewilmington.bakery.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Muffin {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "FLAVOR")
    private String flavor;

    public Muffin(String flavor) {
        this.flavor = flavor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
}
