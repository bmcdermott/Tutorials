package springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import springapp.domain.Component;

@Repository
@RepositoryRestResource
//@RepositoryRestResource(exported=false)
public interface JPAComponentDao  extends  JpaRepository<Component, Integer> {

	@RestResource(path="byDesc")
	List<Component> findByDescription(String desc);
	List<Component> findById(int key);
	

}