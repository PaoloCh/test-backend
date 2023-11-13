package com.greengrow.backend.service.impl;

import com.greengrow.backend.model.Trend;
import com.greengrow.backend.repository.TrendRepository;
import com.greengrow.backend.service.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrendServiceImpl implements TrendService {

    @Autowired
    private TrendRepository trendRepository;

    @Override
    public Trend createTrend(Trend trend){
        return trendRepository.save(trend);
    }
}
