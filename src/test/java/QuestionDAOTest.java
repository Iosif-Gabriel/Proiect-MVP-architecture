import Model.DAO.QuestionDAO;
import Model.Tables.Question;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuestionDAOTest {

    private QuestionDAO questionDAOMock;

    @Before
    public void setup(){
        questionDAOMock=mock(QuestionDAO.class);

    }

    @Test
    public void testGetUser(){
        Question question =new Question("123","Ana are mere?","nu");
        when(questionDAOMock.getQuestion("123")).thenReturn(question);
        assertEquals(questionDAOMock.getQuestion("123"),question);
    }

    @Test
    public void testGetAllUsers() {
        List<Question> questionList = new ArrayList<>();
        questionList.add(new Question("123","Question","answer"));
        questionList.add(new Question("1234","Question","answer"));
        questionList.add(new Question("1235","Question","answer"));
        when(questionDAOMock.findAllQuestions()).thenReturn(questionList);


        List<Question> expectedQuestions = Arrays.asList(
                new Question("123","Question","answer"),
                new Question("1234","Question","answer"),
                new Question("1235","Question","answer")
        );

        assertEquals(expectedQuestions, questionDAOMock.findAllQuestions());
    }

    @Test
    public void testUpdateUser() {
        Question question =new Question("123","Ana are mere?","nu");
        when(questionDAOMock.updateQuestion(question)).thenReturn(true);
        Question updatedQuestion = new Question("123","?","da");
        questionDAOMock.updateQuestion(question);
        assertNotEquals(question, updatedQuestion);
    }

    @Test
    public void testCreateUser(){
        Question question =new Question("123","Ana are mere?","nu");
        when(questionDAOMock.createQuestion(question)).thenReturn(true);
        when(questionDAOMock.getQuestion("123")).thenReturn(question);
        assertEquals(questionDAOMock.getQuestion("123"),question);
    }

    @Test
    public void testDeleteUser(){
        Question question =new Question("123","Ana are mere?","nu");
        when(questionDAOMock.createQuestion(question)).thenReturn(true);
        when(questionDAOMock.deleteQuestion("123")).thenReturn(true);
        when(questionDAOMock.getQuestion("123")).thenReturn(null);
        assertEquals(questionDAOMock.getQuestion("123"),null);

    }
}
