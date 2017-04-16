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
package nl.mierasmade.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;

import io.datafx.controller.FXMLController;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import nl.mierasmade.data.Column;
import nl.mierasmade.fakers.Fakers;
import nl.mierasmade.language.Locales;
import nl.mierasmade.values.FakerValue;
import nl.mierasmade.writer.DataWriter;

@FXMLController(value = "Main.fxml")
public class MainController {

	@FXMLViewFlowContext
	private ViewFlowContext context;

	@FXML private StackPane root;
	@FXML private JFXCheckBox headerCheckBox;
	@FXML private JFXCheckBox footerCheckBox;
	@FXML private JFXTextField delimiterTextField;
	@FXML private JFXTextField linesTextField;
	@FXML private JFXTreeTableView<Column> fakeColumnsView;
    @FXML private JFXTreeTableColumn<Column, String> columnName;
    @FXML private JFXTreeTableColumn<Column, String> fakeType;
    @FXML private JFXTextField columnNameInputTextField;
    @FXML private JFXComboBox<FakerValue> typeDataInputBox;
    @FXML private JFXButton addButton;
    @FXML private JFXButton removeButton;
    @FXML private JFXButton generateButton;
    @FXML private JFXComboBox<Locales> languageChoiceBox;
    @FXML private Label statusLabel;   
    @FXML private ProgressBar progressBar;
    
    private ObservableList<Column> columns = FXCollections.observableArrayList();
    
    private Fakers fakers;
    private DataWriter dataWriter;
    private Stage primaryStage;
    
	@PostConstruct
	public void init() {	
		setupInjection();
		setupTableView(); 	
		setupRowListener();
		setupTextFieldsValidators();
		setupChoiceBox();
		setupAddButtonListener();
		setupAddButtonAction();
		setupRemoveButtonAction();
		setupGenerateButtonListener();
		setupGenerateButtonAction();	
	}
	
	private void setupInjection() {
		fakers = (Fakers) context.getRegisteredObject("fakers");		
		dataWriter = (DataWriter) context.getRegisteredObject("dataWriter");		
		primaryStage = (Stage) context.getRegisteredObject("primaryStage");			
	}

	private void setupTableView() {
		fakeColumnsView.setPlaceholder(new Label("Please add columns"));
		columnName.prefWidthProperty().bind(fakeColumnsView.widthProperty().divide(2)); 
		fakeType.prefWidthProperty().bind(fakeColumnsView.widthProperty().divide(2));
		
		columnName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Column,String>, ObservableValue<String>>() {			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Column, String> param) {
				return param.getValue().getValue().getColumnName();
			}
		});		
		
		fakeType.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Column,String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Column, String> param) {
				FakerValue fakeValue = param.getValue().getValue().getFakeType().get();
				return new SimpleStringProperty(fakeValue.toString());
			}
		});	
		
		
		final TreeItem<Column> root = new RecursiveTreeItem<Column>(columns, RecursiveTreeObject::getChildren);	
		fakeColumnsView.setRoot(root);
		fakeColumnsView.setShowRoot(false);		
	}

	private void setupRowListener() {
		fakeColumnsView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue != null) {
				removeButton.setDisable(false);
		    } else {
		    	removeButton.setDisable(true);		    	
		    }
		});		
	}

	// TODO: custom validator on 1 character
	private void setupTextFieldsValidators() {
		RequiredFieldValidator connectionNameVal = new RequiredFieldValidator();
		delimiterTextField.getValidators().add(connectionNameVal);
		connectionNameVal.setMessage("Delimiter is required");
		delimiterTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {if(!newValue) delimiterTextField.validate();});
		
		NumberValidator linesVal = new NumberValidator();
		linesTextField.getValidators().add(linesVal);		
		linesVal.setMessage("Digit is required");		
		linesTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {if(!newValue) linesTextField.validate();});		
	}

	private void setupChoiceBox() {		
		fakers.getFakerValues().forEach(f -> {
			typeDataInputBox.getItems().add(f);
		});
		
		for (Locales locale : Locales.values()) {
			languageChoiceBox.getItems().add(locale);
		}
		
	}

	private void setupAddButtonListener() {
		BooleanBinding emptyCredentials = columnNameInputTextField.textProperty().isEmpty()
				.or(typeDataInputBox.valueProperty().isNull());
		addButton.disableProperty().bind(emptyCredentials);
	}

	private void setupAddButtonAction() {
		addButton.setOnAction(e -> {
			columns.add(new Column(columnNameInputTextField.getText(), typeDataInputBox.getSelectionModel().getSelectedItem()));
			columnNameInputTextField.clear();
			typeDataInputBox.setValue(null);
		});		
	}

	private void setupRemoveButtonAction() {
		removeButton.setOnAction(e -> {
			Column candidate = fakeColumnsView.getSelectionModel().getSelectedItem().getValue();
			columns.remove(candidate);
			fakeColumnsView.getSelectionModel().clearSelection();
		});		
	}

	private void setupGenerateButtonListener() {
		IntegerBinding sizeProperty = Bindings.size(columns);		
		BooleanBinding generate = delimiterTextField.textProperty().isEmpty()
				.or(linesTextField.textProperty().isEmpty()
				.or(sizeProperty.isEqualTo(0)))
				.or(languageChoiceBox.getSelectionModel().selectedItemProperty().isNull())
				.or(Bindings.createBooleanBinding(() -> !linesTextField.validate(), linesTextField.textProperty()))				
				.or(Bindings.createBooleanBinding(() -> !delimiterTextField.validate(), delimiterTextField.textProperty()));				
		generateButton.disableProperty().bind(generate);		
	}
	
	private void setupGenerateButtonAction() {		
		generateButton.setOnAction(e -> {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Save as...");
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(".csv", "*.csv");
	        fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showSaveDialog(primaryStage);
			
			List<FakerValue> localColumns = new ArrayList<>();
			columns.forEach(c -> {
				localColumns.add(c.getFakeType().get());
			});
			
			// Swallow this for now
			if (file == null) {
				return;
			}
			
			dataWriter.setLanguage(new Locale(languageChoiceBox.getSelectionModel().getSelectedItem().toString()));
			dataWriter.setColumns(localColumns);
			dataWriter.setCount(Integer.valueOf(linesTextField.getText()));
			dataWriter.setFile(file);
			dataWriter.setDelimiter(delimiterTextField.getText());			
			
			progressBar.progressProperty().bind(dataWriter.progressProperty());
			progressBar.progressProperty().addListener((observable, oldValue, newValue) -> {
				if (newValue.doubleValue() == 1) {
					statusLabel.setText("Complete");	
					statusLabel.setTextFill(Color.GREEN);					
				} else {
					statusLabel.setText("Creating fake data");	
					statusLabel.setTextFill(Color.ORANGE);					
				};
			});				
			
			new Thread(dataWriter).start();			
		});		
	}
}