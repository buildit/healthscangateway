package buildit.poc.healthscangateway.model.product;

import buildit.poc.healthscangateway.model.metadata.BrowserInfo;
import buildit.poc.healthscangateway.model.metadata.DeviceInfo;
import buildit.poc.healthscangateway.model.metadata.IPLocation;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import java.time.Instant;

@Value()
@ToString()
@Builder()
public class BarcodeItem {
    String barcode;
    String barcodeType;
    Instant timestamp;
    DeviceInfo deviceInfo;
    BrowserInfo browserInfo;
    IPLocation ipLocation;
}
