package com.greengrow.backend.repository;

import com.greengrow.backend.model.Trend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrendRepository extends JpaRepository<Trend, Long>
{
    Boolean existsByName(String title);
}
