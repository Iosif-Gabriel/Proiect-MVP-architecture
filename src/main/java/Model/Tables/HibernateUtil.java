package Model.Tables;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;

import org.hibernate.boot.MetadataSources;



public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            try{

                StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
                sessionFactory=new MetadataSources(serviceRegistry)
                        .buildMetadata().buildSessionFactory();

            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

}
