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
package nl.mierasmade;

import nl.mierasmade.fakers.FakersConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testfx.framework.junit.ApplicationTest;

import com.jfoenix.controls.JFXDecorator;

import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.container.DefaultFlowContainer;
import io.datafx.controller.flow.context.ViewFlowContext;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.mierasmade.main.MainController;
import nl.mierasmade.writer.DataWriter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuiApplicationTest extends ApplicationTest {

	private ViewFlowContext applicationContext;
	@Autowired
	private FakersConfiguration fakersConfiguration;
	@Autowired
	private DataWriter dataWriter;	

	@Override
	public void start(Stage primaryStage) throws Exception {
		Flow flow = new Flow(MainController.class);
		DefaultFlowContainer container = new DefaultFlowContainer();
		
		applicationContext = new ViewFlowContext();					
		applicationContext.register("primaryStage", primaryStage);		
		applicationContext.register("fakersConfiguration", fakersConfiguration);
		applicationContext.register("dataWriter", dataWriter);		
		flow.createHandler(applicationContext).start(container);
		
		JFXDecorator decorator = new JFXDecorator(primaryStage, container.getView());
		decorator.setCustomMaximize(true);
		Scene scene = new Scene(decorator, 1280, 900);
		scene.getStylesheets().add("css/jfoenix-components.css");
		scene.getStylesheets().add("css/jfoenix-main.css");
		primaryStage.setMinWidth(650);
		primaryStage.setMinHeight(800);
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
	
	@Test
	public void something() {
		// TODO
	}
}
