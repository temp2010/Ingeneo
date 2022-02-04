package co.ingeneo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@Column(name = "id_customer")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCustomer;

	@Column(name = "username")
	private String userName;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	public Customer() {
	}

	public Customer(Integer idCustomer, String userName, String name, String password) {
		this.idCustomer = idCustomer;
		this.userName = userName;
		this.name = name;
		this.password = password;
	}

	public Customer(String userName, String name, String password) {
		this.userName = userName;
		this.name = name;
		this.password = password;
	}

	public Integer getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Integer idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}