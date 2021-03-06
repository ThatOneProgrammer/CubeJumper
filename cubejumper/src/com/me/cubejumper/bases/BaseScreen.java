package com.me.cubejumper.bases;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.me.cubejumper.ActorAccessor;
import com.me.cubejumper.CubeJumper;

/**
 * Base class for all screens.
 * 
 * @author Jacob
 */
public class BaseScreen implements Screen
{
	protected CubeJumper game;
	
	protected Stage stage;
	protected TextureAtlas atlas;
	protected Skin skin;
	protected Table table;
	protected TextButtonStyle buttonStyle;
	protected LabelStyle headingStyle;
	protected BitmapFont white, black;
	protected Label heading;
	protected SpriteBatch batch;
	protected TweenManager tween;
	
	protected int width = Gdx.graphics.getWidth();
	protected int height = Gdx.graphics.getHeight();
	
	@Override
	public void show() {
		batch = new SpriteBatch();
		
		stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);
		
		atlas = new TextureAtlas("ui/bluebutton9.pack");
		skin = new Skin();
		skin.addRegions(atlas);
		
		table = new Table(skin);
		table.setBounds(0, 0, width, height);
		
		//font setup
		white = new BitmapFont(Gdx.files.internal("ui/white.fnt"), false);
		black = new BitmapFont(Gdx.files.internal("ui/black.fnt"), false);
		
		//buttons
		buttonStyle = new TextButtonStyle();
		buttonStyle.up = skin.getDrawable("bluebutton");
		buttonStyle.down = skin.getDrawable("bluebutton_highlighted");
		buttonStyle.over = skin.getDrawable("bluebutton_highlighted");
		buttonStyle.pressedOffsetX = 1;
		buttonStyle.pressedOffsetY = -1;
		buttonStyle.font = white;
		
		headingStyle = new LabelStyle(white, Color.WHITE);
		
		//animations
		tween = new TweenManager();
		Tween.registerAccessor(Actor.class, new ActorAccessor());
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		Table.drawDebug(stage);
		
		tween.update(delta);
		
		stage.act(delta);
		
		batch.begin();
			stage.draw();
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		stage.setViewport(width, height, true);
		
		table.invalidateHierarchy();
		table.setSize(width, height);
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		batch.dispose();
		stage.dispose();
		atlas.dispose();
		white.dispose();
		black.dispose();
		skin.dispose();
	}

}