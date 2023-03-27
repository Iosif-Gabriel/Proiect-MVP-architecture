package Model.Tables;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @Column(name = "idQuestion", nullable = false, unique = true)
    private String idQuestion;

    @Column(name = "question")
    private String question;

    @Column(name="rightAnswer")
    private String rightAnswer;


    public Question() {

    }

    public Question(String idQuestion, String question, String rightAnswer) {
        this.idQuestion = idQuestion;
        this.question = question;
        this.rightAnswer = rightAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(idQuestion, question1.idQuestion) && Objects.equals(question, question1.question) && Objects.equals(rightAnswer, question1.rightAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idQuestion, question, rightAnswer);
    }
}
