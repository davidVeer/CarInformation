package GUI.sceneBuilders;

import GUI.nodeBuilders.crudOptions.ChangeRefuleTank;
import GUI.nodeBuilders.crudOptions.AddRefuleTank;
import GUI.nodeBuilders.crudOptions.RemoveRefuleTank;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class CrudTabs {

	private final ChangeRefuleTank changeRefuleTank;

	private final AddRefuleTank addRefuleTank;

	private final RemoveRefuleTank removeRefuleTank;

	public CrudTabs() {
		changeRefuleTank = new ChangeRefuleTank();
		addRefuleTank = new AddRefuleTank();
		removeRefuleTank = new RemoveRefuleTank();
	}

	public Scene getScene() {
		FlowPane buttons = new FlowPane();

		Button changeButton = new Button("change");
		Button addButton = new Button("add");
		Button removeButton = new Button("remove");

		buttons.getChildren().add(changeButton);
		buttons.getChildren().add(addButton);
		buttons.getChildren().add(removeButton);


		Scene scene = new Scene(buttons);
		return scene;
	}

}
