package GUI.nodeBuilders;

import Data.CarData;
import javafx.scene.Node;

public class DataTable implements nodeGetter {

	private CarData carData;

	public DataTable(CarData carData) {
		this.carData = carData;
	}


	public Node getNode() {
		return null;
	}

}
