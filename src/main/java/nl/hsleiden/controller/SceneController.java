package nl.hsleiden.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nl.hsleiden.iipsene2applicatie.MainApplication;
import nl.hsleiden.service.StageService;

import java.io.IOException;
import java.util.Objects;

/**
 * Controls the function to switch to a different view.
 * @author Hicham El Faquir, Ryan Bhola
 */
public class SceneController {
    private static SceneController sceneController;

    private SceneController() {

    }

    /**
     * With the getInstance() method, we can always make sure that there is only one instance running of this
     * controller. To use this method, create an empty SceneController variable outside the constructor of another
     * class. After that call the getInstance() method in the constructor like the example below.
     *
     * @<code> SceneController sceneController;
     * <p>
     * public DifferentClass(){
     * sceneController = SceneController.getInstance();
     * }
     * </code>
     * @author Hicham El Faquir
     */
    public synchronized static SceneController getInstance() {
        if (sceneController == null) {
            sceneController = new SceneController();
        }
        return sceneController;
    }

    /**
     * General method for switching scenes, insert the fxml file name in parameter when using function to switch to that
     * particular scene.
     * @author Hicham El Faquir, Ryan Bhola
     */
    public void switchToNextScreen(String fileName) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource(fileName)));
            Stage stage = StageService.getInstance().getStage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
