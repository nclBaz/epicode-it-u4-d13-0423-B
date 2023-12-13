package riccardogulin.dao;

import riccardogulin.entities.BlogPost;
import riccardogulin.entities.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CategoriesDAO {
	private final EntityManager em;

	public CategoriesDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Category u) {
		EntityTransaction transaction = em.getTransaction();
		// 1. Inizio la transazione
		transaction.begin();

		// 2. Aggiungo il nuovo oggetto al Persistence Context (ma non è ancora salvato a DB in questo momento)
		em.persist(u);

		// 3. Termino la transazione col salvataggio effettivo di una nuova riga nella tabella students
		transaction.commit();
		System.out.println("Nuovo post salvato correttamente");
	}

	public Category findById(long id) {
		// SELECT * FROM students WHERE students.id=1
		return em.find(Category.class, id);
	}

	public void findByIdAndDelete(long id) {

		// 1. Faccio una find per cercare lo studente
		Category found = em.find(Category.class, id);

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
			System.out.println("Il post è stato cancellato correttamente");
		} else {
			// 3. Altrimenti --> "Student not found"
			System.err.println("Il post con l'id " + id + " non è stato trovato");
		}

	}

	public List<BlogPost> getAllBlogsByCategoryId(long categoryId) {
		Category category = this.findById(categoryId);

		return category.getBlogPostList();
	}
}