package study.springboot.cws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.springboot.cws.Entity.DisputeEntity;

@Repository
public interface DisputeRepository extends JpaRepository<DisputeEntity,Integer>{

}