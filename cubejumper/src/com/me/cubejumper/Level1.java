package com.me.cubejumper;

public class Level1 extends LevelBase
{
	private static final int TEN = 10;
	
	Spikes[] spikeArray = new Spikes[100];
	
	public Level1(CubeJumper game) {
		LevelBase.game = game;
	}
	
	public void show() {
		super.show();
		
		genSpikes(4, 100, 0);
		genSpikes(7, 130, 4);
	}
	
	public void genSpikes(int times, int offset, int pos){
		for(int x = 0 + pos; x < times; x++){
			spikeArray[x] = new Spikes(world, (x * TEN) + offset, 1.5f);
		}
	}
	
	public void render(float delta) {
		super.render(delta);
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
		
		for(int x = 0; x < 100; x++) {
			spikeArray[x].dispose();
		}
	}

}