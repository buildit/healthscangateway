package buildit.poc.healthscangateway.service.barcode;

import buildit.poc.healthscangateway.model.exception.HealthScanGatewayException;
import buildit.poc.healthscangateway.model.exception.LabKitException;
import buildit.poc.healthscangateway.model.exception.MedicationException;
import buildit.poc.healthscangateway.model.exception.WasteDisposalKitException;
import buildit.poc.healthscangateway.model.request.BarcodeRequest;
import buildit.poc.healthscangateway.service.uhg.model.UHGApiResponse;

public interface BarcodeService {
    UHGApiResponse scanAndSave(BarcodeRequest request) throws HealthScanGatewayException;

    void onError(Exception e) throws LabKitException, MedicationException, WasteDisposalKitException;
}
