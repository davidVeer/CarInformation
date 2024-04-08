package GUI;

import GUI.sceneBuilders.CrudTabs;
import GUI.sceneBuilders.MainTab;
import javafx.application.Application;
import javafx.stage.Stage;

public class GuiMain extends Application{

	private CrudTabs crudTabs;

	private MainTab mainTab;

	@Override
	public void init() throws Exception {
		crudTabs = new CrudTabs();
		mainTab = new MainTab();
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
