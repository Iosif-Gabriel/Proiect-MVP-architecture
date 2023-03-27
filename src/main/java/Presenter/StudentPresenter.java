package Presenter;

import Model.Cube;
import Model.DAO.QuestionDAO;
import Model.DAO.UserDAO;
import Model.RandomID;
import Model.Tables.Question;
import View.LogInView;
import View.StudentInterface;
import View.StudentView;

import java.util.*;

public class StudentPresenter {

    private StudentInterface studentView;
    private QuestionDAO questionDAO;
    private int nr=0;
    private List<Question> questionList;
    private List<Question> randomQuestions;
    private int questionIndex=0;


    public StudentPresenter(StudentView studentView){
        this.studentView=studentView;
        questionDAO=new QuestionDAO();
        questionList=questionDAO.findAllQuestions();
        randomQuestions=new ArrayList<>();

    }

    public void backButton(){
        studentView.backButton();
    }


    public String getNextQuestion() {
        if (questionIndex ==10) {
            int finalScore = nr;
            startTest();
            studentView.showPunctaj( "Ai obtinut " + finalScore + " puncte! Apasa pe Test pentru a da testul din nou.");
        } else {

            Question currentQuestion = randomQuestions.get(questionIndex);
            questionIndex++;
            return currentQuestion.getQuestion();
        }
        return " ";
    }

    public void submitAnswer() {
        if (studentView.getAnswer().trim().equalsIgnoreCase(randomQuestions.get(questionIndex - 1).getRightAnswer().trim())) {

            nr++;
        }
    }

    public void startTest(){
        nr=0;
        questionIndex=1;
        randomQuestions = randomTest(questionList).subList(0, 10);
    }

    public List<Question> randomTest(List<Question> list){
        Collections.shuffle(list);
        return new ArrayList<>(list.subList(0,10));
    }

    public void showMessage(){
        studentView.showMessage("Apasa de 2 ori next pentru a incepe");
    }


}
