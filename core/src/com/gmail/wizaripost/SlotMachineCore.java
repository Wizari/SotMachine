package com.gmail.wizaripost;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gmail.wizaripost.managers.GameManager;
import com.gmail.wizaripost.managers.InputManager;

public class SlotMachineCore extends ApplicationAdapter {

    private SpriteBatch batch; // spritebatch ("пачка спрайтов") для отрисовки
    private OrthographicCamera camera;
    private GameManager gameManager;
    private InputManager inputManager;



    @Override
    public void create() {
        // получаем размеры экрана нашего устройтсва
        float height = Gdx.graphics.getHeight();
        float width = Gdx.graphics.getWidth();
        // устанавливаем размеры экрана устройства в качестве размеров области просмотра игры
        camera = new OrthographicCamera(width, height);
        camera.setToOrtho(false); // центруем камеру (w/2, h/2) этой строкой
        batch = new SpriteBatch();
        gameManager = new GameManager();
        gameManager.initialize(width, height);
        inputManager = new InputManager();
    }

    @Override
    public void dispose() {
        super.dispose();
        //утилизация SpriteBatch и текстур
        batch.dispose();
        gameManager.dispose();
    }

    @Override
    public void render() {
        // Очищаем экран
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // передаём вид с "камеры" в наш spritebatch
        batch.setProjectionMatrix(camera.combined);
        inputManager.handleInput(camera, gameManager);
        // отрисовка игровых объектов
        batch.begin();
        gameManager.renderGame(batch);
        batch.end();
    }

}
