package buildit.poc.healthscangateway.model.product;

import buildit.poc.healthscangateway.service.uhg.model.UHGAPIInfo;
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
    UHGAPIInfo uhgAPIInfo;
}
