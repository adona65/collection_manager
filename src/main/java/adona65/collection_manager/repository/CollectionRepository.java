package adona65.collection_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import adona65.collection_manager.entity.CollectionEntity;

/**
 * Repository that allow working with database's table linked to CollectionEntity.
 * 
 * @author adona65
 */
public interface CollectionRepository extends JpaRepository<CollectionEntity, Integer> {
	
}