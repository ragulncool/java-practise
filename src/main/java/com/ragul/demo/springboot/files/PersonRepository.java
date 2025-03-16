package com.ragul.demo.springboot.files;

import com.ragul.demo.springboot.files.Hibernate.Address;
import com.ragul.demo.springboot.files.Hibernate.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {

}
