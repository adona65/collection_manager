package adona65.collection_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import adona65.collection_manager.entity.ItemEntity;

/**
 * Repository that allow working with database's table linked to ItemEntity.
 * 
 * @author adona65
 */
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
	
}