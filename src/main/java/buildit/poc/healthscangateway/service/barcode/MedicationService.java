package buildit.poc.healthscangateway.service.barcode;

import buildit.poc.healthscangateway.model.product.Medication;
import buildit.poc.healthscangateway.model.request.BarcodeRequest;
import buildit.poc.healthscangateway.model.response.ConfirmationResponse;
import buildit.poc.healthscangateway.model.session.SessionMetadata;
import buildit.poc.healthscangateway.service.uhg.UHGGatewayAPIService;
import buildit.poc.healthscangateway.service.uhg.model.UHGAPIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicationService implements BarcodeService, BarcodeMapper<Medication> {

    private final UHGGatewayAPIService uhgGatewayAPIService;
    private final SessionMetadata sessionMetadata;

    @Override
    public ConfirmationResponse scanAndSave(BarcodeRequest request) {
        UHGAPIResponse uhgResponse = uhgGatewayAPIService.saveMedicationToUHG(this.map(request));
        return new ConfirmationResponse(uhgResponse);
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
