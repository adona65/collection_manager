package adona65.collection_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import adona65.collection_manager.entity.UsersEntity;

/**
 * Repository that allow working with database's table linked to UsersEntity.
 * 
 * @author adona65
 */
public interface UsersRepository extends JpaRepository<UsersEntity, String> {
	
	@Query(value = "SELECT count(username) FROM UsersEntity where username = :username")
	Long countByUsername(@Param("username")String usernameString);
}