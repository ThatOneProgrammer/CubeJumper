package com.me.cubejumper.bases;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.me.cubejumper.levels.PlayScreen;

/**
 * World object base class.
 * 
 * @author Jacob
 */
public class BaseObject
{
	protected int width = Gdx.graphics.getWidth() / 5;
	protected int height = Gdx.graphics.getWidth() / 5;
	
	protected PlayScreen play;
	
	protected World world;
	
	protected Body body;
	protected BodyDef bodyDef;
	protected FixtureDef fixDef;
	protected PolygonShape shape;
	
	/**
	 * X, y are in increments of 10
	 * 
	 * @param x - world x position
	 * @param y - world y position<p>
	 * 
	 * @author Jacob
	 */
	protected void init(float x, float y) {
		bodyDef = new BodyDef();
		bodyDef.position.set(x, y);
		bodyDef.active = true;
		
		shape = new PolygonShape();
		
		fixDef = new FixtureDef();
		fixDef.shape = shape;
	}
	
	protected void render() {
	}
	
	protected void dispose() {
		shape.dispose();
	}
}