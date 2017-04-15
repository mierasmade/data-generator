package nl.mierasmade.data;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import nl.mierasmade.values.FakerValue;

public class Column extends RecursiveTreeObject<Column> {

	private SimpleStringProperty columnName;
	private SimpleObjectProperty<FakerValue> fakeType;
	
	public Column(String columnName, FakerValue fakeType) {
		this.columnName = new SimpleStringProperty(columnName);
		this.fakeType = new SimpleObjectProperty<>(fakeType);
	}
	
	public SimpleStringProperty getColumnName() {
		return columnName;
	}
	
	public ObjectProperty<FakerValue> getFakeType() {
		return fakeType;
	}	
}
