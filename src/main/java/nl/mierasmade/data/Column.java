/*******************************************************************************
 * Copyright 2017 Mieras Made
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package nl.mierasmade.data;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import nl.mierasmade.values.FakerValue;

public class Column extends RecursiveTreeObject<Column> {

	private final SimpleStringProperty columnName;
	private final SimpleObjectProperty<FakerValue> fakeType;
	
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
