package com.io.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class PlayerView {
    private final Sprite sprite;

    public PlayerView(TextureManager tm, Vector2 position, float size){
        sprite = new Sprite(tm.getPlayer());
        sprite.setPosition(position.x,position.y);
        sprite.setSize(size,size);
    }
    public void changePosition(Vector2 newPosition){
        sprite.setPosition(newPosition.x, newPosition.y);
    }

    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

}
