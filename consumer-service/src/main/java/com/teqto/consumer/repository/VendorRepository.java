package com.teqto.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.teqto.consumer.entity.Vendor;

/**
 * @author jayant
 *
 */
public interface VendorRepository extends JpaRepository<Vendor, Long>{
	Vendor findByUserid(Long userid);
	}
