package in.sunbase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sunbase.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>{

}
