package com.io.presenter.character;

import com.badlogic.gdx.math.Vector2;
import com.io.core.board.BoardPosition;
import com.io.presenter.CoordinatesManager;
import com.io.view.assets_managers.SoundManager;
import com.io.view.assets_managers.TextureManager;
import com.io.view.characters.CharacterViewType;
import com.io.view.characters.EnemyView;

public class EnemyPresenter extends CharacterPresenter {
    private final int maxHealth;
    private int health;

    public EnemyPresenter(TextureManager tm, SoundManager sm, CoordinatesManager cm, BoardPosition boardPosition, int maxHealth, CharacterViewType type) {
        super(sm, cm, boardPosition, type);

        Vector2 position = cm.calculatePosition(boardPosition);
        characterView = new EnemyView(tm, position, cm.getTileSize(), type);

        this.maxHealth = maxHealth;
        health = maxHealth;

        ((EnemyView) characterView).changeHealth(1);
    }

    public void setHealth(int value) {
        health = value;
        ((EnemyView) characterView).changeHealth((float) health / maxHealth);
    }
}
