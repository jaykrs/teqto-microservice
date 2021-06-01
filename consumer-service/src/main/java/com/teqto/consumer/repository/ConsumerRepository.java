package com.teqto.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.teqto.consumer.entity.Consumer;

/**
 * @author jayant
 *
 */
public interface ConsumerRepository extends JpaRepository<Consumer, Long>{
	Consumer findByUserid(Long userid);
	}
