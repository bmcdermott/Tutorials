package springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import springapp.domain.Component;

@RepositoryRestResource
public interface JPAComponentDao  extends  JpaRepository<Component, Integer> {

	@RestResource(path="byName")
	List<Component> findByDescription(String desc);
	List<Component> findById(int key);
	

}