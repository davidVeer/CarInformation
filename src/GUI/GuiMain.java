package GUI;

import Data.CarData;
import GUI.sceneBuilders.CrudTabs;
import GUI.sceneBuilders.MainTable;
import javafx.application.Application;
import javafx.stage.Stage;

public class GuiMain extends Application{

	private CarData carData;
	private CrudTabs crudTabs;

	private MainTable mainTab;

	@Override
	public void init() throws Exception {
		crudTabs = new CrudTabs();
		mainTab = new MainTable(carData);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setResizable(true);
		primaryStage.setScene(mainTab.getScene());
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
