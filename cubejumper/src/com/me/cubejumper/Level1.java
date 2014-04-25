package com.me.cubejumper;

import com.badlogic.gdx.graphics.Color;

import box2dLight.ConeLight;
import box2dLight.RayHandler;

public class Level1 extends LevelBase
{
	private static final int TEN = 10;
	
	Spikes[] spikeArray = new Spikes[100];
	
	RayHandler handler;
	
	public Level1(CubeJumper game) {
		LevelBase.game = game;
	}
	
	public void show() {
		super.show();
		
		handler = new RayHandler(world);
		
		new ConeLight(handler, 200, Color.BLUE, 1000, 20, 20, 30, 90);
		
		genSpikes(4, 100, 1.5f, 0);
		genSpikes(7, 140, 1.5f, 4);
		genSpikes(9, 160, 2.5f, 7);
	}
	
	public void genSpikes(int times, int offset, float y, int pos){
		for(int x = 0 + pos; x < times; x++){
			spikeArray[x] = new Spikes(world, (x * TEN) + offset, y);
		}
	}
	
	public void render(float delta) {
		super.render(delta);
		
		handler.setCombinedMatrix(camera.combined);
		handler.updateAndRender();
	}
	
	public void resize(int width, int height) {
		super.resize(width, height);
	}
	
	public void hide() {
		super.hide();
	}

	public void pause() {
		super.pause();
	}

	public void resume() {
		super.resume();
	}

	public void dispose() {
		super.dispose();
		
		handler.dispose();
		for(int x = 0; x < 100; x++) {
			spikeArray[x].dispose();
		}
	}

}
