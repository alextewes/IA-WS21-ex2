package com.hbrs.ia.ex2.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

@Document(collection = "performanceRecord")
public class PerformanceRecord {
    private int erid;
    private int actualValue;
    private int targetValue;
    private String goalDescription;
    private int year;
    private int sid;

    public PerformanceRecord(int erid, int actualValue, int targetValue, String goalDescription, int year, int sid) {
        this.erid = erid;
        this.actualValue = actualValue;
        this.targetValue = targetValue;
        this.goalDescription = goalDescription;
        this.year = year;
        this.sid = sid;
    }

    public int getErid() {
        return erid;
    }

    public void setErid(int erid) {
        this.erid = erid;
    }

    public int getActualValue() {
        return actualValue;
    }

    public void setActualValue(int actualValue) {
        this.actualValue = actualValue;
    }

    public int getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(int targetValue) {
        this.targetValue = targetValue;
    }

    public String getGoalDescription() {
        return goalDescription;
    }

    public void setGoalDescription(String goalDescription) {
        this.goalDescription = goalDescription;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "PerformanceRecord{" +
                "erid=" + erid +
                ", actualValue=" + actualValue +
                ", targetValue=" + targetValue +
                ", goalDescription='" + goalDescription + '\'' +
                ", year=" + year +
                ", sid=" + sid +
                '}';
    }
}
