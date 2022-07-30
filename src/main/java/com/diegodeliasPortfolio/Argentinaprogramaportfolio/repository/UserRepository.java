package com.diegodeliasPortfolio.Argentinaprogramaportfolio.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
