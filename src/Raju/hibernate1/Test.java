package Raju.hibernate1;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Raju.hibernate.Details;

public class Test {

	public static void main(String[] args) {
		
		//D.setName("raju");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		/*for(int i=0;i<10;i++){
			Details D=new Details();
			D.setName("user"+ i);
			session.save(D);
		}*/
		Query query= session.createQuery("from Details ");
		query.setFirstResult(6);
		List<Details> users= (List<Details>) query.list();
		
		
		session.getTransaction().commit();
		session.close();
		for(Details u: users){
			System.out.println(u.getName());
		}
		 
		
		
		

	}

}
