package br.com.lgr.drink.control;

import static br.com.lgr.drink.config.DeviceSettings.screenHeight;


import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.transitions.CCFadeTransition;

import br.com.lgr.drink.config.Assets;
import br.com.lgr.drink.scenes.GameScene;

/**
 * Create the buttons used by the game
 * @author Leonardo Ribeiro
 */
public class MenuButtons extends CCLayer implements ButtonDelegate  {
	private Button drinkButton;

	public MenuButtons() {
		this.drinkButton = new Button(Assets.DRINK_BUTTON);
		this.drinkButton.setDelegate(this);
		drinkButton.setPosition(45, (screenHeight() / 2) - 80);
		
		this.addChild(drinkButton);
	}
	
	@Override
	public void buttonClicked(Button sender) {
		
		if (sender.equals(this.drinkButton)) {
			CCDirector.sharedDirector().replaceScene(CCFadeTransition.transition(1.0f, GameScene.createGame()));
		}
	}
}
