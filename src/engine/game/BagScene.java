package engine.game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import authoring.ScreenDisplay;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class BagScene extends ScreenDisplay {
	/*final variable*/
	private final Image INVENTORY_GUI =new Image("file:inventory/inventory_gui.png",480,540,false,false);
	
	// For the explanation box
	public static final String RETURN_MENU = "RETURN";
	private final int BOX_XPOS = 0;
	private final int BOX_YPOS = 360;
	private final Image PANE_POINT = new Image("file:dialog/dialogue_pointer.png",24,24,false,false);
	private final Image TOP_LEFT = new Image("file:dialog/dialogue_top_left.png",32,32,false,false);
	private final Image LEFT = new Image("file:dialog/dialogue_left.png",32,32,false,false);
	private final Image RIGHT = new Image("file:dialog/dialogue_right.png",32,32,false,false);
	private final Image TOP = new Image("file:dialog/dialogue_top.png",32,32,false,false);
	private final Image BOTTOM_LEFT = new Image("file:dialog/dialogue_bottom_left.png",32,32,false,false);
	private final Image TOP_RIGHT = new Image("file:dialog/dialogue_top_right.png",32,32,false,false);
	private final Image BOTTOM_RIGHT = new Image("file:dialog/dialogue_bottom_right.png",32,32,false,false);
	private final Image CONTENT = new Image("file:dialog/dialogue_bg.png",32,32,false,false);
	private final Image BOTTOM = new Image("file:dialog/dialogue_bottom.png",32,32,false,false);
	private final Image WHITE_POINT = new Image("file:dialog/dialogue_bg.png",337,327,false,false);
	private final int BOX_WIDTH = 15;
	private final int BOX_HEIGHT = 4;

	
	/*private variable*/
	private UserPage uPage;
	private UserPageArt uPageArt = new UserPageArt();
	private ArrayList <ItemColomn> colList = new ArrayList <ItemColomn>();
	
	
	public BagScene(int width, int height, Paint background, UserPage userPage) {
		super(width, height, background);
		
		colList.add(new ItemColomn("RETURN", "RETURN TO THE MENU"));
		uPage = userPage;
		this.getScene().setOnKeyPressed(e -> handleKeyInput(e.getCode()));
		this.rootAdd(new ImageView(INVENTORY_GUI), 0, 0);
		this.rootAdd(new ImageView(WHITE_POINT),143,34);
		uPageArt.makeGrid(BOX_WIDTH, BOX_HEIGHT, this.getRoot(), BOX_XPOS, BOX_YPOS);
		uPageArt.setUpBasicItemGrid(this.getRoot(), colList, 200, 60);
		this.rootAdd(useFont(colList.get(0).getExplanation(),20), 15, 400);
	}
	
	
	
	
	
	
	private void handleKeyInput (KeyCode code) {
	if  (code == KeyCode.Z) uPage.goBackToOriScene();
	else if (code == KeyCode.RIGHT) uPage.switchBagSceneRight();
	else if (code == KeyCode.LEFT)  uPage.swithBagSceneLeft();
			
		}
	
	
	
	
	
	
	

	/**
	 * @param target: target String
	 * @param Size: size of the text
	 * @return The Text with the certain target and certain size
	 */
	private Text useFont(String target, int Size) {
		Text ans = new Text(target);
		ans.setFont(getFont(Size));
		
		return ans;
		
	}
	
	
	/**
	 * @return the specific Pokemon font
	 */
	private Font getFont(int fontSize) {
		Font f = new Font(30) ;
		try {
			f = Font.loadFont(new FileInputStream(new File("./font/font.ttf")), fontSize);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
	
	
}
