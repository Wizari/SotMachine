package com.gmail.wizaripost;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gmail.wizaripost.managers.GameManager;

public class MyGdxGame extends ApplicationAdapter {

    SpriteBatch batch; // spritebatch ("пачка спрайтов") для отрисовки
    OrthographicCamera camera;

    @Override
    public void create() {
        // получаем размеры экрана нашего устройтсва
        float height = Gdx.graphics.getHeight();
        float width = Gdx.graphics.getWidth();
        // устанавливаем размеры экрана устройства в качестве размеров области просмотра игры
        camera = new OrthographicCamera(width, height);
        camera.setToOrtho(false); // центруем камеру (w/2, h/2) этой строкой
        batch = new SpriteBatch();
        GameManager.initialize(width, height);//инициализируем игру
    }

    @Override
    public void dispose() {
        super.dispose();
        //утилизация SpriteBatch и текстур
        batch.dispose();
        GameManager.dispose();
    }

    @Override
    public void render() {
        // Очищаем экран
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		InputManager.handleInput(camera);
        // передаём вид с "камеры" в наш spritebatch
        batch.setProjectionMatrix(camera.combined);
        // отрисовка игровых объектов
        batch.begin();
        GameManager.renderGame(batch);
        batch.end();
    }

}
