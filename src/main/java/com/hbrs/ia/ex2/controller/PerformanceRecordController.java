package com.hbrs.ia.ex2.controller;

import com.hbrs.ia.ex2.model.PerformanceRecord;
import com.hbrs.ia.ex2.model.Salesman;
import com.hbrs.ia.ex2.repositories.PerformanceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class PerformanceRecordController {

    @Autowired
    PerformanceRecordRepository performanceRecordRepository;
    @GetMapping("/api/salesmen/{sid}/performanceRecords")
    public List<PerformanceRecord> getPerformanceRecords(@PathVariable int sid) {
        return performanceRecordRepository.findAllBySid(sid);
    }
    @GetMapping("/api/salesmen/{sid}/performanceRecords/{erid}")
    public PerformanceRecord getPerformaneRecord(@PathVariable int sid, @PathVariable int erid) {
        return performanceRecordRepository.findPerformanceRecordByEridAndSid(sid,erid);
    }
    @PostMapping("/api/salesmen/{sid}/performanceRecords")
    public PerformanceRecord createPerformanceRecord(@Valid @RequestBody PerformanceRecord performanceRecord){
        return performanceRecordRepository.save(performanceRecord);
    }
    //TODO: What should be implemented PATCH OR PUT?
    @PatchMapping("/api/salesmen/{sid}/performanceRecords/{erid}")
    public PerformanceRecord updatePerformanceRecord(@Valid @RequestBody PerformanceRecord performanceRecord){
        return null;
    }
    //TODO: Deletes specified entry but doesn't return it
    @DeleteMapping("/api/salesmen/{sid}/performanceRecords/{erid}")
    public PerformanceRecord deletePerformanceRecord(@PathVariable int erid, @PathVariable int sid){
        PerformanceRecord res = performanceRecordRepository.findPerformanceRecordByEridAndSid(erid,sid);
        performanceRecordRepository.deleteByEridAndSid(erid,sid);
        return res;
    }
    //TODO: Does neither delete all performanceRecords nor return them
    @DeleteMapping("/api/salesmen/{sid}/performanceRecords")
    public List<PerformanceRecord> deleteAllPerformanceRecords(@PathVariable int sid){
        List <PerformanceRecord> res = performanceRecordRepository.findAllBySid(sid);
        performanceRecordRepository.deleteBySid(sid);
        return res;
    }
}
