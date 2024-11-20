package com.coffeeisoxygen.model.interfaces;

import com.coffeeisoxygen.model.classes.Player;
import com.coffeeisoxygen.model.classes.Game;

public interface ITileEffect {
    void onPlayerStep(Player player, Game game);
}