package buildit.poc.healthscangateway.model.shared;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum BarcodeCategory {
    MEDICATION("Medication"),
    LAB_KIT("Lab Kits"),
    WASTE_DISPOSAL_KIT("Waste Disposal Kits");

    @Getter
    @JsonValue
    private final String displayName;
}
