package com.mindtree.javaeightnewfeature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.javaeightnewfeature.entity.User;
@Repository
public interface Userrepo extends JpaRepository<User, Long> {

}
