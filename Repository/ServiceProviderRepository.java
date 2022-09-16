package study.springboot.cws.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import study.springboot.cws.Entity.ServiceProviderEntity;



@Repository
public interface ServiceProviderRepository extends JpaRepository<ServiceProviderEntity,Integer>{

	ServiceProviderEntity findByEmailId(String email);

	@Query(value="select * from service_provider_info_tbl where provider_email_id=:eid and provider_password=:pwd",nativeQuery = true)
	ServiceProviderEntity checkLogin(String eid, String pwd);

	List<ServiceProviderEntity> findByRole(String role);

	//ServiceProvider addServiceProvider(ServiceProvider sp);

	//ServiceProvider addServiceProvider(ServiceProvider sp);




}

