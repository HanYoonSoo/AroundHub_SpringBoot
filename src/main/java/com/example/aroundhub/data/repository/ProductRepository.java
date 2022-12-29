package com.example.aroundhub.data.repository;

import com.example.aroundhub.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// 두 번째 id의 값 String, Integer 선택
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
