package java15_validation.lesson21_value_extraction;

import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.UnwrapByDefault;
import jakarta.validation.valueextraction.ValueExtractor;

@UnwrapByDefault
public class DataIntegerValueExtractor implements ValueExtractor<@ExtractedValue(type = Integer.class) DataInteger> {
    @Override
    public void extractValues(@ExtractedValue(type = Integer.class) DataInteger dataInteger, ValueReceiver valueReceiver) {
        valueReceiver.value(null, dataInteger.getData());
    }
}
