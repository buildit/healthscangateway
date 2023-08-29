package buildit.poc.healthscangateway.model.shared;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public enum BarcodeCategory {
    MEDICATION("Medication"),
    LAB_KIT("Lab Kit"),
    WASTE_DISPOSAL_KIT("Waste Disposal Kit");

    private static final Map<String, BarcodeCategory> BY_DISPLAY_NAME = new HashMap<>();

    static {
        for (BarcodeCategory e : values()) {
            BY_DISPLAY_NAME.put(e.displayName.toLowerCase(), e);
        }
    }

    @Getter
    @JsonValue
    private final String displayName;

    public static BarcodeCategory valueOfDisplayName(String displayName) {
        return BY_DISPLAY_NAME.get(displayName.toLowerCase());
    }
}
