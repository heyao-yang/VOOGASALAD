package data.items;

import data.model.Pokemon;
import data.player.Player;

/**
 * 
 * @author Mason Taylor
 * Item that grants 50 points of experience.
 */

public class XPBoost extends Item{
	
	private static final long serialVersionUID = 1296292968492235173L;

	//Specifies name, price and image in the constructor
	public XPBoost(){
		itemName = "XPBoost";
		itemPrice = 50;
	}
	
	//Overrides the useItem function that every item has
	@Override
	public void useItem(Player player, Pokemon mine, Pokemon Enemy) {
		//mine.getCurrentStat().setHP(200);
		mine.absorbExperience(50);
	}
}
