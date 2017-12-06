package data.map;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import data.event.Event;
import data.event.EventNPC;
import data.event.EventPokemon;
import engine.UI.Path2Image;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * Used by Game Scene to draw the Game Map on the screen
 * @author nathanlewis
 *
 */


public class DrawMap extends DrawPane{
	
	/*FINAL VIARABLE*/
	final static int TILE_SIZE = 48;
	

	public DrawMap(GameMap map, GraphicsContext gc) {
		super(map);
		generateTiles(gc);
		drawCells();
	}
	
	/*
	 * Used in game scene to retrieve the grid pane for drawing
	 */
	public GridPane getPane() {
		return myPane;
	}
	
	/*
	 * Adds the cell image to the grid pane
	 */
	private void drawCells() {
		
		for (int i = 0; i < myMap.getXlength(); i++) {
			for (int j = 0; j < myMap.getYlength(); j++) {
				if(myMap.getCells()[i][j].getEvent()!=null){
					if(myMap.getCells()[i][j].getEvent() instanceof EventPokemon) {
						myPane.add(new ImageView(Path2Image.showImage("images/default.png")), j, i);
					}else{
						ImageView target = getCellEventImage(myMap.getCells()[i][j]);
						target.setFitHeight(TILE_SIZE);
						target.setFitWidth(TILE_SIZE);
						myPane.add(target, j, i);
					}
				}
			}
		}
		
	}
	
	/*
	 * Returns cell image view based on tile path
	 */
	private ImageView getCellEventImage(Cell cell) {
		ImageView image = new ImageView();
		image = createImageView(cell.getEvent().getImagePath());
		return image;
	}
	
	/*
	 * Simple method to return an image view based on tile path name
	 */
	private ImageView createImageView(String filename) {
		BufferedImage bufImage = null;
		try {
			bufImage = ImageIO.read(new File(filename));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Tile image could not be loaded");
		}
		Image image = SwingFXUtils.toFXImage(bufImage, null);
		ImageView graphic = new ImageView(image);
		graphic.setFitHeight(PANE_CELL_SIZE);
		graphic.setFitWidth(PANE_CELL_SIZE);
		return graphic;
	}
	
	

	
	/*
	 * Simple method to generate all the tiles below the NPC
	 */
	
	private void generateTiles(GraphicsContext gc) {

		for (int i = 0; i < myMap.getXlength(); i++) {
			for (int j = 0; j < myMap.getYlength(); j++) {

				gc.drawImage(Path2Image.scale(Path2Image.showImage(myMap.getCells()[i][j].getTilePath()), TILE_SIZE, TILE_SIZE, false).snapshot(null, null),  j * TILE_SIZE, i * TILE_SIZE);
				
					if (myMap.getCells()[i][j].isObstacle()) {
						// add empty imageView
						ImageView defaultPicture = new ImageView(Path2Image.showImage("images/default.png"));
						
						String style_outter = "-fx-border-color: black;"
					              + "-fx-border-width: 10;";
						defaultPicture.setStyle(style_outter);
						myPane.add(defaultPicture, j, i);
						
				}
			}
		}
	}
	
	
	
}
