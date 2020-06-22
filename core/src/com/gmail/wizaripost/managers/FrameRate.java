package com.gmail.wizaripost.managers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class FrameRate {

    static BitmapFont font ; // we draw the text to the screen using this variable // отображаем текст на экране через эту переменную
    // размеры области просмотра нашей игры
    static float width,height;

    public void initialize(float width,float height){

        font = new BitmapFont();
        FrameRate.width = width;
        FrameRate.height= height;
        // устанавливаем цвет шрифта красным
        font.setColor(Color.GREEN);
        // масштабируем размер шрифта в соответсвии с шириной экрана
        font.getData().setScale(width/800f);
    }

    public  void displayFPS(SpriteBatch batch){

        // объект класса GlyphLayout хранит в себе информацию о шрифте и содержании текста
        GlyphLayout glyphLayout = new GlyphLayout();
        glyphLayout.setText(font, "FPS: " + Gdx.graphics.getFramesPerSecond());

        // отображаем результат в правом верхнем углу
        font.draw(batch, glyphLayout, width - width/1.01f, height*0.04f);

    }

}

