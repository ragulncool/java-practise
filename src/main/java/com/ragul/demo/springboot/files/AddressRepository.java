package com.ragul.demo.springboot.files;

import com.ragul.demo.springboot.files.Hibernate.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

}
