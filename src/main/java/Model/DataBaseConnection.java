package Model;


import Model.DAO.QuestionDAO;
import Model.DAO.UserDAO;
import Model.Tables.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataBaseConnection {
    public static void main(String[] args) {
      /* Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }*/

       RandomID randomID=new RandomID();
        //UserDAO userDAO=new UserDAO();

       /* User user1=new User(randomID.getRandomID(), "Nita","Gabriel","admin","nitagabriel","123");
        User user=new User(randomID.getRandomID(), "Nita123","Gabriel123","student","student","123");
        userDAO.createUser(user1);
        userDAO.createUser(user);*/


        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            try (BufferedReader reader = new BufferedReader(new FileReader("intrebariPoliedre.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String question1 = line.trim();
                    String rightAnswer = reader.readLine();
                    Question newQuestion = new Question(randomID.getRandomID(),question1.substring(question1.indexOf(":") + 1).trim(), rightAnswer.substring(rightAnswer.indexOf(":") + 1).trim());
                    session.save(newQuestion);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            session.getTransaction().commit();
        }
    }

}
