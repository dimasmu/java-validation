package com.example.java.validation;


import com.example.java.validation.container.Data;
import com.example.java.validation.container.DataInteger;
import com.example.java.validation.container.Entry;
import com.example.java.validation.entities.SampleData;
import com.example.java.validation.entities.SampleDataInteger;
import com.example.java.validation.entities.SampleEntry;
import org.junit.jupiter.api.Test;

public class ValueExtractorTest extends AbstractValidatorTest {

    @Test
    void testSampleData() {

        SampleData data = new SampleData();
        data.setData(new Data<>());
        data.getData().setData(" ");

        validate(data);
    }

    @Test
    void testSampleEntry() {
        SampleEntry entry = new SampleEntry();
        entry.setEntry(new Entry<>());
        entry.getEntry().setKey("");
        entry.getEntry().setValue("");

        validate(entry);

    }

    @Test
    void testSampleDataInteger() {
        SampleDataInteger sampleDataInteger = new SampleDataInteger();
        sampleDataInteger.setDataInteger(new DataInteger());
        sampleDataInteger.getDataInteger().setData(0);
        validate(sampleDataInteger);
    }

}
