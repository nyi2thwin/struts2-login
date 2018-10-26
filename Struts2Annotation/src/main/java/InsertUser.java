import org.hibernate.Session;
import com.struts2.model.User;
import com.struts2.hibernate.util.HibernateUtil;
 
public class InsertUser {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();     
        User s = new User("admin", "123");
        session.save(s);
        session.getTransaction().commit();
	}
}