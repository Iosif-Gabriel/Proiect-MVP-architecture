package Model.DAO;

import Model.Tables.HibernateUtil;
import Model.Tables.Question;
import Model.Tables.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class QuestionDAO {
    public Boolean createQuestion(Question question){
        boolean created=false;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the user object
            //cauta sa vezi daca e in baza de date
            session.save(question);
            created=true;
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return created;
    }

    public List<Question> findAllQuestions() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Question> cq = cb.createQuery(Question.class);
        Root<Question> rootEntry = cq.from(Question.class);
        CriteriaQuery<Question> all = cq.select(rootEntry);

        TypedQuery<Question> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    public Boolean updateQuestion(Question question) {
        boolean success=false;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the user object
            session.update(question);
            // commit transaction
            transaction.commit();
            success=true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return success;
    }

    public Boolean deleteQuestion(String id) {
        boolean deleted=false;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a user object
           Question question = session.get(Question.class, id);
            if (question != null) {
                session.delete(question);
                deleted=true;
            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return deleted;
    }

    public Question getQuestion (String id) {

        Transaction transaction = null;
        Question question= null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get a user object
            question = session.get(Question.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return question;
    }


}
