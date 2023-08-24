package buildit.poc.healthscangateway.service.barcode;

import buildit.poc.healthscangateway.model.request.BarcodeRequest;
import buildit.poc.healthscangateway.model.response.ConfirmationResponse;

public interface BarcodeService {
    ConfirmationResponse scanAndSave(BarcodeRequest request);
}
