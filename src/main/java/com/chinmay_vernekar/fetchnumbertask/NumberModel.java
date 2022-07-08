package com.chinmay_vernekar.fetchnumbertask;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

public class NumberModel {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer categoryCode;

    //Old Value
    private Integer value;

    // Making Transient because don't want to persist it in DB as a column
    @Transient
    private Integer newValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(Integer categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getNewValue() {
        return newValue;
    }

    public void setNewValue(Integer newValue) {
        this.newValue = newValue;
    }
}
