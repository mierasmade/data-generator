package nl.mierasmade;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;

public abstract class GuiApplicationSupport extends Application {
	
	private static String[] savedArgs;

	private ConfigurableApplicationContext applicationContext;

	@Override
	public void init() throws Exception {
		applicationContext = SpringApplication.run(getClass(), savedArgs);
		applicationContext.getAutowireCapableBeanFactory().autowireBean(this);
	}

	@Override
	public void stop() throws Exception {
		super.stop();
		applicationContext.close();
	}

	protected static void launchApp(Class<? extends GuiApplicationSupport> appClass, String[] args) {
		GuiApplicationSupport.savedArgs = args;
		Application.launch(appClass, args);
	}
}
