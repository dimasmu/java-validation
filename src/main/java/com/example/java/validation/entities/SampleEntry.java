package com.example.java.validation.entities;

import com.example.java.validation.container.Entry;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SampleEntry {

    @NotNull
    private Entry<@NotBlank String, @NotBlank String> entry;

    public Entry<String, String> getEntry() {
        return entry;
    }

    public void setEntry(Entry<String, String> entry) {
        this.entry = entry;
    }
}
