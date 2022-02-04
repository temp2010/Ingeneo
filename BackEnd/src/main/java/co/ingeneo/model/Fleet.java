package co.ingeneo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fleets")
public class Fleet {

	@Id
	@Column(name = "id_fleet")
	private Integer idFleet;

	public Fleet() {
	}

	public Fleet(Integer idFleet) {
		this.idFleet = idFleet;
	}

	public Integer getIdFleet() {
		return idFleet;
	}

	public void setIdFleet(Integer idFleet) {
		this.idFleet = idFleet;
	}

}
