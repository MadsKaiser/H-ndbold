package com.example.handbold;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Hold {
    private final StringProperty navn;
    private final IntegerProperty point;
    private final IntegerProperty placering;

    public Hold(String navn, int point, int placering) {
        this.navn = new SimpleStringProperty(navn);
        this.point = new SimpleIntegerProperty(point);
        this.placering = new SimpleIntegerProperty(placering);
    }

    public String getNavn() {
        return navn.get();
    }

    public void setNavn(String navn) {
        this.navn.set(navn);
    }

    public StringProperty navnProperty() {
        return navn;
    }

    public int getPoint() {
        return point.get();
    }

    public void setPoint(int point) {
        this.point.set(point);
    }

    public IntegerProperty pointProperty() {
        return point;
    }

    public int getPlacering() {
        return placering.get();
    }

    public void setPlacering(int placering) {
        this.placering.set(placering);
    }

    public IntegerProperty placeringProperty() {
        return placering;
    }
}