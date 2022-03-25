package com.CGI.prediction.models;

public class NameGender {
    
    public NameGender() {
    }
    private String name;
    private String gender;
    private Float probability;
    private Integer count;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Float getProbability() {
        return probability;
    }
    public void setProbability(Float probability) {
        this.probability = probability;
    }
    public Integer getCount() {
        return count;
    }
    public void setCount(Integer count) {
        this.count = count;
    }
    public NameGender(String name, String gender, Float probability, Integer count) {
        this.name = name;
        this.gender = gender;
        this.probability = probability;
        this.count = count;
    }
    
}
