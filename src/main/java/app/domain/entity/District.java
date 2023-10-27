package app.domain.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="districts")
public class District {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

	@NotEmpty(message = "Please provide a name for district")
    private String name;

	@NotNull
    private Integer stateId;
    
    private String slug;

    private Boolean status;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
    
    public District() {
    	
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setState(Integer stateId) {
		this.stateId = stateId;
	}
}