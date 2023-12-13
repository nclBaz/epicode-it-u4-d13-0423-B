package riccardogulin.dao;

import riccardogulin.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UsersDAO {
	private final EntityManager em;

	public UsersDAO(EntityManager em) {
		this.em = em;
	}

	public void save(User user) {
		EntityTransaction transaction = em.getTransaction();
		// 1. Inizio la transazione
		transaction.begin();

		// 2. Aggiungo il nuovo oggetto al Persistence Context (ma non è ancora salvato a DB in questo momento)
		em.persist(user);

		// 3. Termino la transazione col salvataggio effettivo di una nuova riga nella tabella students
		transaction.commit();
		System.out.println("Nuovo user salvato correttamente");
	}

	public User findById(long id) {
		// SELECT * FROM students WHERE students.id=1
		return em.find(User.class, id);
	}

	public void findByIdAndDelete(long id) {

		// 1. Faccio una find per cercare lo studente
		User found = em.find(User.class, id);

		if (found != null) {
			// 2. Se lo studente c'è, lo elimino

			// 2.1 Ottengo la transazione
			EntityTransaction transaction = em.getTransaction();

			// 2.2 Faccio partire la transazione
			transaction.begin();

			// 2.3 Rimuovo l'oggetto dal persistence context
			em.remove(found);

			// 2.4 Faccio il commit della transazione per persistere a db l'operazione
			transaction.commit();
			System.out.println("Lo user è stato cancellato correttamente");
		} else {
			// 3. Altrimenti --> "Student not found"
			System.err.println("Lo user con l'id " + id + " non è stato trovato");
		}


	}
}
