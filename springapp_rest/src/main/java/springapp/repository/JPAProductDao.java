package springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import springapp.domain.Product;

@Repository
@RepositoryRestResource
public interface JPAProductDao  extends  JpaRepository<Product, Integer> {

	@RestResource(path="byName")
	List<Product> findByDescription(String desc);
	List<Product> findById(int key);
	

}