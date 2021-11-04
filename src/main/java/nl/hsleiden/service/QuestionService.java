package nl.hsleiden.service;

import nl.hsleiden.DAO.QuestionDAO;
import nl.hsleiden.controller.ContentController;
import nl.hsleiden.model.Question;

import java.util.List;

public class QuestionService {
    private final QuestionDAO questionDAO;
    private final ContentController contentController;

    public QuestionService() {
        questionDAO = new QuestionDAO();
        contentController = ContentController.getInstance();
    }

    public List<Question> getAll() {
        List<Question> questions = this.questionDAO.getAll();
        questions.forEach(contentController::addContent);
        return questions;
    }
}
