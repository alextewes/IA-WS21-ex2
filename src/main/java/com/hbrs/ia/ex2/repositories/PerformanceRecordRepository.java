package com.hbrs.ia.ex2.repositories;

import com.hbrs.ia.ex2.model.PerformanceRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PerformanceRecordRepository extends MongoRepository<PerformanceRecord, String> {
    List<PerformanceRecord> findAllBySid(int sid);
    PerformanceRecord findPerformanceRecordByEridAndSid(int erid, int sid);
    List<PerformanceRecord> deleteBySid(int sid);
    PerformanceRecord deleteByEridAndSid(int erid, int sid);
}
