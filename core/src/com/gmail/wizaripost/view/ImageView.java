package com.gmail.wizaripost.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ImageView implements IView {
    int id;
    Sprite sprite;
    Texture texture;

    public ImageView(int idFile) {
        this.id = idFile;
    }

    void create() {
        texture = new Texture(Gdx.files.internal(id + ".png"));
    }

    @Override
    public Texture getTexture() {
        return texture;
    }

    @Override
    public float getX() {
        return 0;
    }

    @Override
    public float getY() {
        return 0;
    }

    @Override
    public void setVisible() {

    }

}
