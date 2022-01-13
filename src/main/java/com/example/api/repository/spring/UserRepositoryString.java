package com.example.api.repository.spring;

import com.example.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface UserRepositoryString extends PagingAndSortingRepository<User, Long> {

/*    List<User> findAll(Pageable pageable);*/

    Optional<User> findByEmail(String email);
}
