package com.example.java.validation.entities;

import com.example.java.validation.container.DataInteger;
import jakarta.validation.constraints.Min;

public class SampleDataInteger {

    @Min(value = 10)
    private DataInteger dataInteger;

    public DataInteger getDataInteger() {
        return dataInteger;
    }

    public void setDataInteger(DataInteger dataInteger) {
        this.dataInteger = dataInteger;
    }
}
