package br.com.lgr.drink.scenes;

import static br.com.lgr.drink.config.DeviceSettings.screenHeight;
import static br.com.lgr.drink.config.DeviceSettings.screenResolution;
import static br.com.lgr.drink.config.DeviceSettings.screenWidth;

import java.util.ArrayList;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGRect;

import android.view.MotionEvent;
import br.com.lgr.drink.config.Assets;
import br.com.lgr.drink.engines.BeerEngine;
import br.com.lgr.drink.screens.ScreenBackground;
import br.com.lgr.drink.sprites.DrinkMan;

/**
 * This is where the game run.
 * In this class will have the logic for the bottles fall and the user will need to catch them using
 * the drink man.
 * 
 * @author Leonardo Ribeiro.
 *
 */
public class GameScene extends CCLayer  {

	int x, y;

	private ArrayList<CCSprite> bottles = new ArrayList<CCSprite>();

	private ScreenBackground background;
	private CCSprite drinkManOpenMouth;
	private CCSprite drinkManCloseMouth;

	BeerEngine engine;
	private GameScene() {
		this.setIsTouchEnabled(true);
		this.background = new ScreenBackground(Assets.BACKGROUND);
		this.background.setPosition(screenResolution(CGPoint.ccp(
				screenWidth() / 2.0f, screenHeight() / 2.0f)));
		addChild(this.background);

		drinkManOpenMouth = CCSprite.sprite(Assets.DRINK_MAN_OPEN_MOUTH);
		drinkManOpenMouth.setPosition(screenWidth() / 2,
				DrinkMan.DEFAULT_HEIGHT);
		drinkManOpenMouth.setTag(DrinkMan.TAG_MOUTH_OPENED);

		addChild(drinkManOpenMouth);
		
		// TODO: Not used yet, but will be used to make the effect of open and close the mouth
		drinkManCloseMouth = CCSprite.sprite(Assets.DRINK_MAN_CLOSED_MOUTH);
		drinkManCloseMouth.setPosition(screenWidth() / 2,
				DrinkMan.DEFAULT_HEIGHT);
		drinkManCloseMouth.setTag(DrinkMan.TAG_MOUTH_CLOSED);

		this.engine = new BeerEngine();
		addChild(engine);
	}

	@Override
	public boolean ccTouchesMoved(MotionEvent event) {
		switch (event.getAction()) {

		case MotionEvent.ACTION_MOVE:
			// this stuff does the magic! every time you move the drink man the
			// x and y coordinates will change.
			x = (int) event.getX();
			y = (int) event.getY();

			// if the coordinate y is greater than 10 (default value)
			if (y > DrinkMan.DEFAULT_HEIGHT) {
				y = DrinkMan.DEFAULT_HEIGHT;
			}

			// this will update only the position x, once the y will be always DrinkMan.DEFAULT_HEIGHT
			this.drinkManOpenMouth.setPosition(x, y);
			// this will make the collision detection occur.
			for (CCSprite beer : this.engine.getBottles()) {

				CGRect rectDrinkMan = CGRect.make(new CGRect());
				rectDrinkMan.set(x, y,
						this.drinkManOpenMouth.getContentSize().width,
						this.drinkManOpenMouth.getContentSize().height);
				CGRect rectBottle = CGRect.make(new CGRect());
				rectBottle.set(beer.getPosition().x, beer.getPosition().y,
						beer.getContentSize().width,
						beer.getContentSize().height);
				if (CGRect.intersects(rectDrinkMan, rectBottle)) {
					removeChild(beer, true);
					// TODO: Test this logic.
					// SoundEngine.sharedEngine().playEffect(get, R.raw.effect);
					// removeChildByTag(DrinkMan.TAG_MOUTH_CLOSED, true);

					// int beerValue = (Integer)beer.getUserData();
					// value+=beerValue;
					// score.setString("");
					//
					// score.setString(""+value);
					// this.drinkMan = new
					// DrinkMan("drink_man_aberto.png").getThisSprite();
					// drinkMan.setPosition(winSize.width / 2,
					// DrinkMan.DEFAULT_HEIGHT);
					// drinkMan.setTag(DrinkMan.TAG_MOUTH_OPENED);
				}

				// this.addChild(drinkMan);
			}
			break;
		default:
			break;
		}
		return true;
	}

	public static CCScene createGame() {
		CCScene scene = CCScene.node();
		GameScene layer = new GameScene();
		scene.addChild(layer);
		return scene;
	}
}
