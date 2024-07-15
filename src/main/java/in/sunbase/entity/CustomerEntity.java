package in.sunbase.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	private String first_Name;
	private String last_Name;
	private String street;
	private String address;
	private String city;
	private String state;
	private String email;
	private String phoneNo;
}
