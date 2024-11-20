package com.coffeeisoxygen.model.classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.coffeeisoxygen.model.interfaces.IMapLoader;
import com.coffeeisoxygen.model.interfaces.ITileFactory;

public class CustomMapLoader implements IMapLoader {
    private final ITileFactory tileFactory;
    private final String directoryPath;
    private final String fileName;

    public CustomMapLoader(ITileFactory tileFactory, String directoryPath, String fileName) {
        this.tileFactory = tileFactory;
        this.directoryPath = directoryPath;
        this.fileName = fileName;
    }

    @Override
    public Board loadMap() {
        File file = new File(directoryPath, fileName);
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Board) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}