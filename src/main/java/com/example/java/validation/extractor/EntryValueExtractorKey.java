package com.example.java.validation.extractor;

import com.example.java.validation.container.Entry;
import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;

public class EntryValueExtractorKey implements ValueExtractor<Entry<@ExtractedValue ?, ?>> {

    @Override
    public void extractValues(Entry<?, ?> entry, ValueReceiver valueReceiver) {
        valueReceiver.keyedValue(null, "key", entry.getValue());
    }

}
