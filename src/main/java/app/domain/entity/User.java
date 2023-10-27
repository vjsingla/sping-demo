package app.domain.entity;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Getter
@Entity
@Table(name="users")
public class User {
    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

    private String firstname;
    
    private String lastname;

	@NotNull
    private String username;

	@NotNull
    private String password;

    private String email;
    
    private Boolean status;
    
    private LocalDateTime created;
    
    private LocalDateTime modified;

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}
}