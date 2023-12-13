package riccardogulin.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "documents")
public class Document {
	@Id
	@GeneratedValue
	private long id;

	private LocalDate issueDate;
	private String country;
	private String code;

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
	// Join Column identifica dove posizioniamo la chiave esterna
	// Nullable = false serve per far si che non sia possibile NON inserire quel valore al suo interno
	private User user;

	public Document() {
	}

	public Document(LocalDate issueDate, String country, String code, User user) {
		this.issueDate = issueDate;
		this.country = country;
		this.code = code;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Document{" +
				"id=" + id +
				", issueDate=" + issueDate +
				", country='" + country + '\'' +
				", code='" + code + '\'' +
				", user=" + user +
				'}';
	}
}
