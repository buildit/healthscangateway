package buildit.poc.healthscangateway.model.product;

import buildit.poc.healthscangateway.model.tracking.TrackingInfo;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import java.util.List;

@ToString()
@Value()
@Builder()
public class WasteDisposalKit {
    BarcodeItem barcodeItem;
    String kitType;
    List<String> contents;
    String disposalInstructions;
    String handlingWarnings;
    TrackingInfo trackingInfo;
}
