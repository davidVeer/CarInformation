package GUI.nodeBuilders;

import Data.CarData;
import Data.RefuleTank;
import javafx.scene.Node;

import javax.swing.text.TableView;

public class DataTable implements nodeGetter {

	private CarData carData;

	public DataTable(CarData carData) {
		this.carData = carData;
	}


	public Node getNode() {
		return null;
	}

}
