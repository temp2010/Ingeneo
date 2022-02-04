package co.ingeneo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trucks")
public class Truck {

	@Id
	@Column(name = "plate")
	private String plate;

	public Truck() {
	}

	public Truck(String plate) {
		this.plate = plate;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

}
