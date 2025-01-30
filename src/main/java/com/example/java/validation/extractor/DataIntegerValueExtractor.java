package com.example.java.validation.extractor;

import com.example.java.validation.container.DataInteger;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.UnwrapByDefault;
import jakarta.validation.valueextraction.ValueExtractor;

@UnwrapByDefault
public class DataIntegerValueExtractor implements ValueExtractor<@ExtractedValue(type = Integer.class) DataInteger> {
    @Override
    public void extractValues(DataInteger originalValue, ValueReceiver valueReceiver) {
        valueReceiver.value(null, originalValue.getData());
    }
}
