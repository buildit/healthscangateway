package buildit.poc.healthscangateway.service.barcode;

import buildit.poc.healthscangateway.model.exception.MedicationException;
import buildit.poc.healthscangateway.model.exception.UGHGatewayAPIServiceException;
import buildit.poc.healthscangateway.model.product.Medication;
import buildit.poc.healthscangateway.model.request.BarcodeRequest;
import buildit.poc.healthscangateway.model.session.SessionMetadata;
import buildit.poc.healthscangateway.service.uhg.UHGGatewayAPIService;
import buildit.poc.healthscangateway.service.uhg.model.UHGApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicationService implements BarcodeService, BarcodeMapper<Medication> {

    private final UHGGatewayAPIService uhgGatewayAPIService;
    private final SessionMetadata sessionMetadata;

    @Override
    public UHGApiResponse scanAndSave(BarcodeRequest request) throws UGHGatewayAPIServiceException {
        return uhgGatewayAPIService.saveMedicationToUHG(this.map(request));
    }

    @Override
    public void onError(Exception e) throws MedicationException {
        String message = "An error occurred while processing the medication: %s".formatted(e.getMessage());
        throw new MedicationException(message, e);
    }

    @Override
    public Medication map(BarcodeRequest request) {
        return Medication.builder()
                .barcodeItem(this.mapBarCode(request, sessionMetadata))
                .expirationDate(null)
                .manufacturer("Manufacturer")
                .medicineName("Medicine Name")
                .dosage("Dosage")
                .build();
    }
}
