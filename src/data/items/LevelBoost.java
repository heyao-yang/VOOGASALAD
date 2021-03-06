package data.items;

import data.model.Pokemon;
import data.player.Player;

/**
 * 
 * @author Mason Taylor
 * Item that grants a level up.
 */

public class LevelBoost extends Item{
	
	private static final long serialVersionUID = 3329845208040856863L;

	//Specifies name, price and image in the constructor
	public LevelBoost(){
		itemName = "LevelBoost";
		itemPrice = 50;
	}
	
	//Overrides the useItem function that every item has
	@Override
	public void useItem(Player player, Pokemon mine, Pokemon Enemy) {
		//mine.getCurrentStat().setHP(200);
		mine.changeCurrentLevel(mine.getCurrentLevel() + 1);
	}
}
