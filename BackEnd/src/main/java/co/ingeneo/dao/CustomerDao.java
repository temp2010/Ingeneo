package co.ingeneo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ingeneo.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
