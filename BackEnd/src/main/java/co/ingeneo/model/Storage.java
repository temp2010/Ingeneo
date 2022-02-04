package co.ingeneo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "storages")
public class Storage {

	@Id
	@Column(name = "id_storage")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idStorage;

	@Column(name = "name")
	private String name;

	public Storage() {
	}

	public Storage(Integer idStorage, String name) {
		this.idStorage = idStorage;
		this.name = name;
	}

	public Integer getIdStorage() {
		return idStorage;
	}

	public void setIdStorage(Integer idStorage) {
		this.idStorage = idStorage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
