package study.springboot.cws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.springboot.cws.Entity.ServiceInfoEntity;


@Repository
public interface ServiceInfoRepository extends JpaRepository<ServiceInfoEntity, Integer>{

}
