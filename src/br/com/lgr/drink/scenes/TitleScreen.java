package br.com.lgr.drink.scenes;

import static br.com.lgr.drink.config.DeviceSettings.screenHeight;
import static br.com.lgr.drink.config.DeviceSettings.screenResolution;
import static br.com.lgr.drink.config.DeviceSettings.screenWidth;

import org.cocos2d.actions.base.CCRepeatForever;
import org.cocos2d.actions.interval.CCFadeIn;
import org.cocos2d.actions.interval.CCFadeOut;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

import br.com.lgr.drink.config.Assets;
import br.com.lgr.drink.control.MenuButtons;
import br.com.lgr.drink.screens.ScreenBackground;

/**
 * Represents the first screen of the game.
 * @author Leonardo Ribeiro
 *
 */
public class TitleScreen extends CCLayer {
	
	private ScreenBackground background;
	
	public TitleScreen() {
		this.background = new ScreenBackground(Assets.BACKGROUND);
		this.background.setPosition(screenResolution(
				CGPoint.ccp(screenWidth() / 2.0f, screenHeight() / 2.0f)));
		addChild(this.background);
		
		CCSprite singpostLit = CCSprite.sprite(Assets.SINGPOST_LIT);
		CCSprite singpostOut = CCSprite.sprite(Assets.SINGPOST_OUT);
		
		singpostLit.setPosition(screenWidth() / 2, screenHeight() - 35);
		singpostOut.setPosition(screenWidth() / 2, screenHeight() - 35);
		
		this.addChild(singpostLit, 0);
		this.addChild(singpostOut, 0);
		
		CCSprite shelfOne = CCSprite.sprite(Assets.SHELF_1);
		shelfOne.setPosition(screenWidth() / 2, (screenHeight() / 2) + 130);
		
		CCSprite shelfTwo = CCSprite.sprite(Assets.SHELF_2);
		shelfTwo.setPosition(screenWidth() / 2, (screenHeight() / 2) + 60);
		
		this.addChild(shelfOne);
		this.addChild(shelfTwo);
		
		MenuButtons buttons = new MenuButtons();
		this.addChild(buttons);
		
		CCSprite drinkMan1 = CCSprite.sprite(Assets.DRINK_BOY_1);
		CCSprite drinkMan2 = CCSprite.sprite(Assets.DRINK_BOY_2);
		
		drinkMan1.setPosition(screenWidth() / 2, 50);
		drinkMan2.setPosition(screenWidth() / 2, 50);
		
		this.addChild(drinkMan1);
		
		CCRepeatForever fadeOut = CCRepeatForever.action(CCFadeOut.action(0.5f));
		CCRepeatForever fadeIn = CCRepeatForever.action(CCFadeIn.action(0.5f));
	
		singpostOut.runAction(fadeIn);
		singpostLit.runAction(fadeOut);
	
	}
	
	public CCScene scene() {
		CCScene scene = CCScene.node();
		scene.addChild(this);
		return scene;
	}
	
	

}
