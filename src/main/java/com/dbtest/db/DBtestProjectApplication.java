package com.dbtest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class DBtestProjectApplication extends Application {

	@Autowired
	private SpringFXMLLoader fxmlLoader;
	@Autowired
	private ConfigurableApplicationContext springContext;

    @Override
    public void init() {
    	springContext = SpringApplication.run(DBtestProjectApplication.class);
        fxmlLoader = springContext.getBean(SpringFXMLLoader.class);
    	System.out.println("initされた");
    }

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent parent = fxmlLoader.load(getClass().getResource("view/MainScene.fxml"));
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("TOP画面");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
