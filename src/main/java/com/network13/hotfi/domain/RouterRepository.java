package com.network13.hotfi.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RouterRepository extends JpaRepository<Router, Long> {
    Boolean existsByIp(String ip);

    Optional<Router> findByIp(String ip);
}
