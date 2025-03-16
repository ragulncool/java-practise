package com.ragul.demo.springboot;

import com.ragul.demo.springboot.Hibernate.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBRepository extends JpaRepository<Address, String> {

}
