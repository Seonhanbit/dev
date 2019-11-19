package com.ssafy.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.model.MemberUser;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<MemberUser, Long> {
    Optional<MemberUser> findByEmail(String email);

    Optional<MemberUser> findByUsernameOrEmail(String username, String email);

    List<MemberUser> findByIdIn(List<Long> userIds);

    Optional<MemberUser> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
