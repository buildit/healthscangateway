package buildit.poc.healthscangateway.service.barcode;

import buildit.poc.healthscangateway.model.request.BarcodeRequest;
import buildit.poc.healthscangateway.service.uhg.model.UHGAPIResponse;

public interface BarcodeService {
    UHGAPIResponse scanAndSave(BarcodeRequest request);
}
