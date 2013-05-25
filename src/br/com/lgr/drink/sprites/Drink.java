package br.com.lgr.drink.sprites;

import org.cocos2d.nodes.CCSprite;

/**
 * 
 * Sprite class that represents a Drink.
 * Each drink have the image associated and a value which is used to
 * let us know how much points the user will have in the end of the game.
 *
 * @author Leonardo Ribeiro
 *
 */
public class Drink extends CCSprite {

	private String imageName;
	private int value;
	
	public Drink (String fileName, int value) {
		super(fileName);
		this.value = value;
	}
	
	public String getFilename() {
		return imageName;
	}

	public void setFilename(String filename) {
		this.imageName = filename;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	
}
