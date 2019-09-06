package crm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

import javax.persistence.*;

@Entity(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Please provide a valid e-mail")
    @NotEmpty(message = "Please provide an e-mail")
    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private int enabled;

    @ManyToOne
    private Role role;

    public int getColumnCount() {
        return getClass().getDeclaredFields().length;
    }

    public int getRole_id() {
        return role.getId();
    }

    public String getRole_name() {
        return role.getName();
    }

    public String getName() {
        return firstName + " " + lastName;
    }

	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	public Role getRole() {
		// TODO Auto-generated method stub
		return role;
	}

	public void setRole(Role userRole) {
		// TODO Auto-generated method stub
		this.role = userRole;
	}

	public long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public void setEnabled(int i) {
		// TODO Auto-generated method stub
	    this.enabled = i;	
	}

	public void setPassword(String encode) {
		// TODO Auto-generated method stub
	password = encode;	
	}

	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}

	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	public int getEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}

}
