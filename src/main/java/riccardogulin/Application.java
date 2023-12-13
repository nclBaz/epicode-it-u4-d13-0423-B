package riccardogulin;

import riccardogulin.dao.BlogpostsDAO;
import riccardogulin.dao.DocumentsDAO;
import riccardogulin.dao.UsersDAO;
import riccardogulin.entities.BlogPost;
import riccardogulin.entities.Document;
import riccardogulin.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4d13");

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();

		UsersDAO ud = new UsersDAO(em);
		DocumentsDAO dd = new DocumentsDAO(em);
		BlogpostsDAO bd = new BlogpostsDAO(em);

		// ******************************** 1 TO 1 **********************************
		User aldo = new User("Aldo", "Baglio");
		// ud.save(aldo);

		User aldoFromDB = ud.findById(3);

		// Document aldoDoc = new Document(LocalDate.now(), "Italy", "213oijoi231j", aldoFromDB);
		//dd.save(aldoDoc);

		System.out.println(aldoFromDB);
		System.out.println("Il documento di aldo è: " + aldoFromDB.getDocument()); // Questa possibilità ce l'ho grazie alla BIDIREZIONALITA'

		Document aldoDoc = dd.findById(5);
		System.out.println(aldoDoc);


		// ******************************** 1 TO MANY **********************************
		// BlogPost java = new BlogPost("React", "React è bellissimo ma non come Java", aldoFromDB);
		// bd.save(java);
		BlogPost javaFromDB = bd.findById(6);
		System.out.println(javaFromDB);

		System.out.println("------------ BIDIREZIONALITA' PER IL 1 TO MANY ----------------------");
		aldoFromDB.getBlogPostList().forEach(System.out::println);


	}
}
