package com.zxw.repository;

import com.zxw.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MostRepo  extends JpaRepository<Information,Long> {
}
