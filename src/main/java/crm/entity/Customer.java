package crm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    @Size(min = 2)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Please provide a valid e-mail")
    @NotEmpty(message = "Please provide an e-mail")
    private String email;

    @Digits(fraction = 0, integer = 20)
    private int phone;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "customer_category",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    private String firstName;

    private String lastName;

    private String city;

    private String address;

    private int enabled;

	public Customer(long l, String name2, String email2, int phone2, Set<Category> categories2, String firstName2,
			String lastName2, String city2, String address2, int enabled2) {
		// TODO Auto-generated constructor stub
	this.id = l;
	this.name = name2;
	this.email = email2;
	this.phone = phone2;
	this.categories = categories;
	this.firstName = firstName2;
    this.lastName = lastName2;
    this.city = city2;
    this.address = address2;
    this.enabled = enabled2;
	}

	

	public Customer() {
		// TODO Auto-generated constructor stub
	}



	public void setEnabled(int i) {
		// TODO Auto-generated method stub
		this.enabled = i;
		
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	public int getPhone() {
		// TODO Auto-generated method stub
		return phone;
	}

	public Set<Category> getCategories() {
		// TODO Auto-generated method stub
		return categories;
	}

	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}

	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}

	public String getCity() {
		// TODO Auto-generated method stub
		return city;
	}

	public String getAddress() {
		// TODO Auto-generated method stub
		return address;
	}

	public int getEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}

}
