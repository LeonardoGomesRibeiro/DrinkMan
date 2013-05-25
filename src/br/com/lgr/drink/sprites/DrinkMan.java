package br.com.lgr.drink.sprites;

import org.cocos2d.nodes.CCSprite;

/**
 * Class that represents the drink man.
 * @author Leonardo
 *
 */
public class DrinkMan extends CCSprite {

	// Default height used to let the drunk man on the bottom.
	public static final int DEFAULT_HEIGHT = 50;
	public static final int TAG_MOUTH_OPENED = 10;
	public static final int TAG_MOUTH_CLOSED = 12;
	
	private CCSprite thisSprite;
	
	public DrinkMan(String imgPath) {
		this.thisSprite = sprite(imgPath);
	}
	
	public CCSprite getThisSprite() {
		return thisSprite;
	}
	
}
