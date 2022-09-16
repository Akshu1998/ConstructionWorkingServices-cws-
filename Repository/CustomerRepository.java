package study.springboot.cws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import study.springboot.cws.Entity.CustomerEntity;

@Repository
public interface CustomerRepository  extends JpaRepository<CustomerEntity,Integer>{

	@Query(value="select * from customer_info_tbl where customer_email_id=:eid and customer_password=:pwd",nativeQuery = true)
	CustomerEntity checkLogin(String eid, String pwd);

	CustomerEntity findByEmailId(String email);

}