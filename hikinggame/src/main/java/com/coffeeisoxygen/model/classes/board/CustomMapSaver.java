package com.coffeeisoxygen.model.classes.board;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.coffeeisoxygen.model.interfaces.IMapSaver;

public class CustomMapSaver implements IMapSaver {
    private final String directoryPath;
    private final String fileName;

    public CustomMapSaver(String directoryPath, String fileName) {
        this.directoryPath = directoryPath;
        this.fileName = fileName;
    }

    @Override
    public void saveMap(BoardRefactored board) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(directory, fileName)))) {
            oos.writeObject(board);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}