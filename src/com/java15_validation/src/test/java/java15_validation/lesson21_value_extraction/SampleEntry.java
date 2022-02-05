package java15_validation.lesson21_value_extraction;

import jakarta.validation.constraints.NotBlank;

public class SampleEntry {

    private Entry<@NotBlank String, @NotBlank String> entry;

    public Entry<String, String> getEntry() {
        return entry;
    }

    public void setEntry(Entry<String, String> entry) {
        this.entry = entry;
    }
}
