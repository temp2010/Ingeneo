package co.ingeneo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ingeneo.model.Storage;

public interface StorageDao extends JpaRepository<Storage, Integer> {

}
