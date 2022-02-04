package co.ingeneo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ingeneo.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
