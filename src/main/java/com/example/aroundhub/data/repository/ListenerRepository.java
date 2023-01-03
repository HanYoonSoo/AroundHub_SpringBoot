package com.example.aroundhub.data.repository;

import com.example.aroundhub.data.entity.ListenerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListenerRepository extends JpaRepository<ListenerEntity, Long> {
}
