package authoring;



import com.sun.prism.paint.Color;

import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;

// basic class for editing screen
public class BasicAuthorScreen extends ScreenDisplay{
	
	//final variable
	private final static int WIDTH = 1000;
	private final static int HEIGHT = 600;

	
	//instance variable
	private Button NextScene;
	private Button BackScene;
	private StageDelegate stageHelper;


	public BasicAuthorScreen(int width, int height, Paint background,StageDelegate stageHelper) {
		super(width, height, background);
		// TODO Auto-generated constructor stub
		this.stageHelper = stageHelper;
		ButtonInit();
		
	}
	
	/**
	 * @param background: background color
	 * @param stageHelper: the stageDelegate interface which helps to add event handler
	 * @param index: the scene index in the Array
	 */
	public BasicAuthorScreen(Paint background,StageDelegate stageHelper) {
	
		super(WIDTH, HEIGHT,background);
		// TODO Auto-generated constructor stub
		this.stageHelper = stageHelper;
		ButtonInit();
		
	}
	
	
	
	
	private void ButtonInit() {
		HBox ButtonBox = new HBox();
		NextScene = new Button("GO");
		BackScene = new Button("BACK");
		
		//Set EventHandler for Buttons; Once clicked, go to the next scene or the back scene
		NextScene.addEventHandler(MouseEvent.MOUSE_CLICKED, e->stageHelper.GoButtonPressed());
		BackScene.addEventHandler(MouseEvent.MOUSE_CLICKED, e->stageHelper.BackButtonPressed());
		
		ButtonBox.getChildren().add(NextScene);
		ButtonBox.getChildren().add(BackScene);
		ButtonBox.setLayoutX(600);
		ButtonBox.setLayoutY(500);
		this.rootAdd(ButtonBox);
		
	}
	
}