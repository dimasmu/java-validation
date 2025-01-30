package com.example.java.validation.entities;

import com.example.java.validation.container.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SampleData {

    private Data<@NotBlank @Size(min = 10) String> data;

    public Data<@NotBlank @Size(min = 10) String> getData() {
        return data;
    }

    public void setData(Data<@NotBlank @Size(min = 10) String> data) {
        this.data = data;
    }
}
