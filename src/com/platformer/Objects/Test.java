package com.platformer.Objects;

import java.awt.Graphics;
import java.util.LinkedList;

import com.platformer.framework.GameObject;
import com.platformer.framework.ObjectId;

public class Test extends GameObject{

	public Test(float x, float y, ObjectId id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick(LinkedList<GameObject> object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	
	//GETTERS AND SETTERS
	
	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setX(float x) {
		// TODO Auto-generated method stub
		this.x = x;
	}

	@Override
	public void setY(float y) {
		// TODO Auto-generated method stub
		this.y = y;
	}

	@Override
	public float getVelX() {
		// TODO Auto-generated method stub
		return velX;
	}

	@Override
	public float getVelY() {
		// TODO Auto-generated method stub
		return velY;
	}

	@Override
	public void setVelX(float velx) {
		// TODO Auto-generated method stub
		this.velX = velX;
	}

	@Override
	public void setVelY(float vely) {
		// TODO Auto-generated method stub
		this.velY = velY;
	}

	@Override
	public ObjectId getId() {
		// TODO Auto-generated method stub
		return id;
	}

}
