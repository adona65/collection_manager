package adona65.collection_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import adona65.collection_manager.entity.AuthoritiesEntity;

/**
 * Repository that allow working with database's table linked to AuthoritiesEntity.
 * 
 * @author adona65
 */
public interface AuthoritiesRepository extends JpaRepository<AuthoritiesEntity, String> {}