import org.hibernate.Session;

import br.com.projetoweb.util.HibernateUtil;

public class Teste {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionsFactory().openSession();
		session.close();
		HibernateUtil.getSessionsFactory().close();

	}

}
