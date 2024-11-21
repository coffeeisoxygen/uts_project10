package com.coffeeisoxygen.model.classes;

import com.coffeeisoxygen.model.util.Coordinate;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Player {
    private String name;
    private int energy;
    private boolean isAlive;
    private boolean isWinning;
    private Coordinate position;
    private final PropertyChangeSupport support;

    public Player(int energy, String name, Coordinate startPosition) {
        this.energy = energy;
        this.name = name;
        this.isAlive = true;
        this.isWinning = false;
        this.position = startPosition;
        this.support = new PropertyChangeSupport(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        support.firePropertyChange("name", oldName, name);
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        int oldEnergy = this.energy;
        this.energy = energy;
        support.firePropertyChange("energy", oldEnergy, energy);
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        boolean oldIsAlive = this.isAlive;
        this.isAlive = isAlive;
        support.firePropertyChange("isAlive", oldIsAlive, isAlive);
    }

    public boolean isWinning() {
        return isWinning;
    }

    public void setWinning(boolean isWinning) {
        boolean oldIsWinning = this.isWinning;
        this.isWinning = isWinning;
        support.firePropertyChange("isWinning", oldIsWinning, isWinning);
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        Coordinate oldPosition = this.position;
        this.position = position;
        support.firePropertyChange("position", oldPosition, position);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}