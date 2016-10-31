package evg.testt.dao;


import evg.testt.model.User;
import evg.testt.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsDao extends JpaRepository<UserDetails, Integer> {

}
