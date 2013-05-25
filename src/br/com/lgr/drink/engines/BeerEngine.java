package br.com.lgr.drink.engines;

import static br.com.lgr.drink.config.DeviceSettings.*;

import java.util.ArrayList;
import java.util.Random;

import org.cocos2d.actions.interval.CCMoveTo;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

import br.com.lgr.drink.control.BeerEngineDelegate;
import br.com.lgr.drink.uils.BottlesFactory;
import br.com.lgr.drink.uils.BottlesImpl;

public class BeerEngine extends CCLayer {

	private BeerEngineDelegate delegate;
	
	private ArrayList<CCSprite> bottles = new ArrayList<CCSprite>();
	
	public BeerEngine() {
		this.bottles = new ArrayList<CCSprite>();
		this.schedule("beerEngine", 1.0f);
	}
	
	public void beerEngine(float f) {
		Random random = new Random();
		
		int bottleNumber = (int) 1 + random.nextInt(9);
		BottlesFactory bottleFactory = new BottlesImpl();
		CCSprite drink = bottleFactory.getBottle(bottleNumber);

		int tagNumber = (int) 30 + random.nextInt(100);

		int xPosition = (int) 0 + random.nextInt((int)screenWidth());
		
		int minY = (int) (drink.getContentSize().height / 2.0f) + 77;
		int actualY = random.nextInt((int) screenWidth()) + minY;

		// Create the target slightly off-screen along the right edge,
		// and along a random position along the Y axis as calculated above
		// positioning the object on center of screen and on top.
		drink.setPosition(xPosition, screenHeight());
		addChild(drink);

		drink.setTag(tagNumber);
		bottles.add(drink);

		// Determine speed of the target
		int actualDuration = 4;// random.nextInt(rangeDuration) + minDuration;

		// Create the actions
		CCMoveTo actionMove = CCMoveTo.action(actualDuration,
				CGPoint.ccp(xPosition, -actualY));
		CCSequence actions = CCSequence.actions(actionMove);
		
		drink.runAction(actions);
	}
	
	
	public ArrayList<CCSprite> getBottles() {
		return bottles;
	}
}
