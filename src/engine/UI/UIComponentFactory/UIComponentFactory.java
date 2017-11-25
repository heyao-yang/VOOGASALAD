package engine.UI.UIComponentFactory;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

/**
 * 
 * @author cy122
 * This class is a factory for creating the components of UI, such as buttons, menuItems.
 *
 */

public class UIComponentFactory {
	static public MenuItem createMenuItem(String title, EventHandler<ActionEvent> handler){
		MenuItem result =  new MenuItem(title);
		result.setOnAction(handler);
		return result;
	}
	
	static public HBox intSlider(int initialValue, int left, int right, Callback<Integer, Integer> saver){
		HBox result =new HBox();
		Label levelLabel = new Label("Lv: " + String.valueOf(initialValue));
		Slider slider = new Slider();
        levelLabel.textProperty().bind(
                Bindings.format(
                    "Lv: %.0f",
                    slider.valueProperty()
                )
         );
		slider.setMin(left);
		slider.setMax(right);
		slider.setValue(initialValue);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		slider.setMajorTickUnit((left+right)/2+1);
		slider.setMinorTickCount(5);
		slider.setBlockIncrement(1);
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    saver.call(new_val.intValue());
            }
        });
		result.getChildren().addAll(slider, levelLabel);
		return result;
	}
}
