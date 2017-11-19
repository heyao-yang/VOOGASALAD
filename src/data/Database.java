package data;

import java.io.Serializable;
import java.util.ArrayList;

import data.event.Event;
import data.map.Map;
import data.model.Model;
import data.player.Player;

// workspace is the exact class which will be stored into XML file using serialization
// every time a new game is created to be edited, the Authoring should create a new Workspace class,
// and set all the necessary values in it to be default values, when user wants to save, 
// then the related Workspace Object should be serialized and stored.

public class Database implements Serializable{
	private static final long serialVersionUID = -7248010162820532176L;
	// because image in JavaFX cannot be serialized, so it's preferred to use String Array to store maps, 
	// where the String presents as the absolute path of the image
	private Map map;
	private Model database;
	private Player player;
}