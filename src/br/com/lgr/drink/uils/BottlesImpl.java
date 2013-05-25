package br.com.lgr.drink.uils;

import org.cocos2d.nodes.CCSprite;

import br.com.lgr.drink.sprites.Drink;
import static br.com.lgr.drink.config.Assets.*;

/**
 * this class will generate the drink based on the image number.
 * @author Leonardo Ribeiro
 *
 */
public class BottlesImpl extends BottlesFactory {

	CCSprite drink;
	
	@Override
	public CCSprite getBottle(int imageNumber) {
		
		switch (imageNumber) {
		case 1:
			drink = new Drink(WINE_1, 1);
			break;
		case 2:
			drink = new Drink(WINE_2, 1);
			break;
		case 3:
			drink = new Drink(WINE_3, 1);
			break;
		case 4:
			drink = new Drink(WINE_4, 1);
			break;
		case 5:
			drink = new Drink(WINE_5, 1);
			break;
		case 6:
			drink = new Drink(WINE_6, 1);
			break;
		case 7:
			drink = new Drink(WINE_7, 1);
			break;
		case 8:
			drink = new Drink(WISKY_1, 1);
			break;
		case 9:
			drink = new Drink(CHOPP, 1);
			break;	
		default:
			break;
		}
		
		return drink;
	}

}
