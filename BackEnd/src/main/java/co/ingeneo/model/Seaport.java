package co.ingeneo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seaports")
public class Seaport {

	@Id
	@Column(name = "id_seaport")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idSeaport;

	@Column(name = "name")
	private String name;

	public Seaport() {
	}

	public Seaport(Integer idSeaports, String name) {
		this.idSeaport = idSeaports;
		this.name = name;
	}

	public Integer getIdSeaports() {
		return idSeaport;
	}

	public void setIdSeaports(Integer idSeaports) {
		this.idSeaport = idSeaports;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
