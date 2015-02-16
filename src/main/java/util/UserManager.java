package util;

import logic.User;
import org.hibernate.Session;

import java.util.List;

public class UserManager {

    public static void main(String[] args) {
        UserManager mgr = new UserManager();

        if (args[0].equals("store")) {
            mgr.createAndStoreEvent("User One");
        }
        else if (args[0].equals("list")) {
            List events = mgr.listUsers();
            for (int i = 0; i < events.size(); i++) {
                User u = (User) events.get(i);
                System.out.println("User: " + u.getName());
            }
        }

        HibernateUtil.getSessionFactory().close();
    }

    private List listUsers() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from User").list();
        session.getTransaction().commit();
        return result;
    }

    private void createAndStoreEvent(String title) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        User u = new User();

        u.setName(title);
        session.flush();
        session.save(u);

        session.getTransaction().commit();
    }

}