package nl.mierasmade;

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
import nl.mierasmade.fakers.Fakers;
import nl.mierasmade.main.MainController;
import nl.mierasmade.writer.DataWriter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuiApplicationTest extends ApplicationTest {

	private ViewFlowContext applicationContext;
	@Autowired
	private Fakers fakers;
	@Autowired
	private DataWriter dataWriter;	

	@Override
	public void start(Stage primaryStage) throws Exception {
		Flow flow = new Flow(MainController.class);
		DefaultFlowContainer container = new DefaultFlowContainer();
		
		applicationContext = new ViewFlowContext();					
		applicationContext.register("primaryStage", primaryStage);		
		applicationContext.register("fakers", fakers);		
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
