package study.springboot.cws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.springboot.cws.Entity.BookingEntity;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity,Integer>{

}
