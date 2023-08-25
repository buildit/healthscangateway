package buildit.poc.healthscangateway.model.product;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import java.util.List;

@ToString()
@Value()
@Builder()
public class LabKit {
    BarcodeItem barcodeItem;
    String kitName;
    List<String> components;
    String instructions;
    String manufacturer;
    String intendedUse;
}
