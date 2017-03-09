package springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springapp.domain.Product;

@Repository
public interface JPAProductDao  extends  JpaRepository<Product, Integer> {

	List<Product> findByDescription(String desc);
	List<Product> findById(int key);
	

}