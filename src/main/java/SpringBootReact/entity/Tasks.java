package SpringBootReact.entity;


import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tasks")
public class Tasks {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String title;
	    private String description;
	    private String status;

	    @Enumerated(EnumType.STRING) 
	    private Priority priority; 

	    @CreationTimestamp
	    @Temporal(TemporalType.TIMESTAMP)
	    private Date createdAt;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Priority getPriority() {
			return priority;
		}

		public void setPriority(Priority priority) {
			this.priority = priority;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		@Override
		public String toString() {
			return "Tasks [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
					+ ", priority=" + priority + ", createdAt=" + createdAt + "]";
		}

		public Tasks(Long id, String title, String description, String status, Priority priority, Date createdAt) {
			super();
			this.id = id;
			this.title = title;
			this.description = description;
			this.status = status;
			this.priority = priority;
			this.createdAt = createdAt;
		}

		public Tasks() {
			super();
			// TODO Auto-generated constructor stub
		}

		public String getTitle() {
			// TODO Auto-generated method stub
			return title;
		}
	    

}
