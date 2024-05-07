package ec.edu.uce.Proyecto_004;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Student;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        
        configuration.addAnnotatedClass(Student.class);
        
        // Create Session Factory and auto-close with try-with-resources.
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
 
            Session session = sessionFactory.openSession();
 
            Student student = new Student();
            student.setId(2);
            student.setName("Marco");
            student.setLastname("Cedeño");
            student.setAge(19);
 
            session.beginTransaction();
            session.persist(student); 
            session.getTransaction().commit();
        }
    }
}
