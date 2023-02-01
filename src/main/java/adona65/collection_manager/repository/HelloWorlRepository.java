package adona65.collection_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import adona65.collection_manager.entity.HelloWorldEntity;

/**
 * Repository that allow working with database's table linked to HelloWorldEntity.
 * 
 * @author adona65
 */
public interface HelloWorlRepository extends JpaRepository<HelloWorldEntity, Long> {}