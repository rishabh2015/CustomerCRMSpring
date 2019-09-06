package crm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String content;

    private BigDecimal value;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate beginDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private User user;

	public LocalDate getEndDate() {
		// TODO Auto-generated method stub
		return endDate;
	}

	public LocalDate getBeginDate() {
		// TODO Auto-generated method stub
		return beginDate;
	}

	public BigDecimal getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public Status getStatus() {
		// TODO Auto-generated method stub
		return status;
	}

	public Customer getCustomer() {
		// TODO Auto-generated method stub
		return customer;
	}

	public User getUser() {
		// TODO Auto-generated method stub
		return user;
	}

//    @Transient
//    private DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

}
