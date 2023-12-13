package riccardogulin;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4d13");

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}
