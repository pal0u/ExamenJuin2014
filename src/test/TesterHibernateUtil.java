package test;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Arbitre;
import pojo.Blessures;
import pojo.President;
import pojo.Clubs;
import pojo.CorrespondantQualifie;
import pojo.Coach;
import pojo.Delegue;
import pojo.Equipes;
import pojo.Joueurs;
import pojo.Lieux;
import pojo.Matchs;
import pojo.Suspensions;


public class TesterHibernateUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session = null;
		session = HibernateUtil.instance().openSession();
		
		Transaction tx = null;
		try{
			tx = session.beginTransaction(); //commencer la transaction
			// les opérations avec Hibernate
			
			//Creer un objet arbitre
		    //Arbitre arbitre = new Arbitre(2002,"Putman","Jonathan");
			//session.persist(arbitre);
			//President president = new President("Furia","Tonio","2004-2009");
			//session.persist(president);
			//CorrespondantQualifie correspondantqualifie = new CorrespondantQualifie ("Lecomte","Olivier","+32494651916","ArgentinosLL@hotmail.com");
			//session.persist(correspondantqualifie);
			//Joueurs jou = new Joueurs(256525,new Date(),"pepi","angeloni");
			//session.persist(jou);
			//Clubs club = new Clubs(2729,"Argentinos La Louvière",president,correspondantqualifie);
			//session.persist(club);
			//Matchs match = new Matchs(654456,new Date(),"20h15","?-?",arbitre);
			//session.persist(match);
			
			tx.commit();
			System.out.println("pas de problème de mapping");
		}
		catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}
		finally {
			session.close(); 
		}
		
	}

}
