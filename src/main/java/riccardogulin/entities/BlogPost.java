package riccardogulin.entities;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class BlogPost {
	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String content;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user; // <--- FOREIGN KEY
}
