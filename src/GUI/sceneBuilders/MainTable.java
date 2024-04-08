package GUI.sceneBuilders;


import Data.CarData;
import GUI.nodeBuilders.DataTable;
import javafx.scene.*;

public class MainTable {

	private DataTable dataTable;

	public MainTable(CarData carData) {
		this.dataTable = new DataTable(carData);
	}

	public Scene getScene() {
        return new Scene(dataTable.getNode().getParent());
	}

}
