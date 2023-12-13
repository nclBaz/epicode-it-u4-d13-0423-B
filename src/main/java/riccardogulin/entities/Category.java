package riccardogulin.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue
	private long id;
	private String name;

	@ManyToMany
	@JoinTable(name = "blogs_categories", // DEFINIAMO COME SARA' FATTA LA JUNCTION TABLE
			joinColumns = @JoinColumn(name = "category_id"), // DEFINIAMO I NOMI DELLE SUE COLONNE
			inverseJoinColumns = @JoinColumn(name = "blog_id")
	)
	private List<BlogPost> blogPostList;

	public Category() {
	}

	public Category(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BlogPost> getBlogPostList() {
		return blogPostList;
	}

	public void setBlogPostList(List<BlogPost> blogPostList) {
		this.blogPostList = blogPostList;
	}

	@Override
	public String toString() {
		return "Category{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
