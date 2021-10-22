package nl.hsleiden.controller;

import javafx.util.Pair;
import nl.hsleiden.model.*;
import nl.hsleiden.service.HistoryService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class ContentController {
    private static ContentController contentController;
    private final HistoryService historyService;
    private final SceneController sceneController;
    private final ArrayList<Content> ourDatabase = new ArrayList<>();
/*    private int contentId = 1;*/


    private ContentController(HistoryService historyService){
        this.historyService = historyService;
        sceneController = SceneController.getInstance();

    }


    public synchronized static ContentController getInstance() {
        if (contentController == null) {
            contentController = new ContentController(new HistoryService());
        }
        return contentController;
    }

    public void buildDatabase() throws IOException {
        QuestionController.getInstance().getQuestions();
        ResultController.getInstance().getResults();

        for (Content content : ourDatabase) {
            System.out.println(content.getId());
            System.out.println(content.getValue());
            System.out.println(content.getAnswer().toString());
        }
    }

    public void addContent(Content content){
        ourDatabase.add(content);
    }

    public void removeContent(Content content) {
        ourDatabase.remove(content);
    }

    public Content getContentById(int id) {
        for (Content content : ourDatabase) {
            if(content.getId() == id) {
                return content;
            }
        }
        return null;
    }

    public void nextContent() {
        historyService.add(new Explanation(1,"checkme",new Answer(1,"world", 1,1)), new Answer(1,"world", 1,1));
        Pair<Content, Answer> historyContent = historyService.getLast();
        int nextContentId = historyContent.getValue().getNextContentId();
        Content content = getContentById(nextContentId);

        if (content instanceof Question) {
            System.out.println("vraag");
//            sceneController.switchToNextScreen();
        } else if (content instanceof Video) {
            System.out.println("video");
//            sceneController.switchToNextScreen();
        } else if (content instanceof Result){
            System.out.println("resultaten");
//            sceneController.switchToNextScreen();
        } else if (content instanceof Explanation){
            System.out.println("uitleg");
//            sceneController.switchToNextScreen();
        }

    }

/*    public void nextContentId(){
        this.contentId += 1;
    }
    public  void previousContentId(){
        this.contentId -= 1;
    }*/


}
