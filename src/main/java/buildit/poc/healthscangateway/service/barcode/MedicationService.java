package buildit.poc.healthscangateway.service.barcode;

import buildit.poc.healthscangateway.model.exception.MedicationException;
import buildit.poc.healthscangateway.model.exception.UGHGatewayAPIServiceException;
import buildit.poc.healthscangateway.model.product.Medication;
import buildit.poc.healthscangateway.model.request.BarcodeRequest;
import buildit.poc.healthscangateway.model.session.SessionMetadata;
import buildit.poc.healthscangateway.service.uhg.UHGGatewayAPIService;
import buildit.poc.healthscangateway.service.uhg.model.UHGApiResponse;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MedicationService implements BarcodeService<Medication>, BarcodeMapper<Medication> {

    private final UHGGatewayAPIService uhgGatewayAPIService;
    private final SessionMetadata sessionMetadata;
    private final Faker faker = new Faker();

    @Override
    public UHGApiResponse scanAndSave(BarcodeRequest request) throws UGHGatewayAPIServiceException {
        return uhgGatewayAPIService.saveMedicationToUHG(this.map(request));
    }

    @Override
    public Medication getBarcodeDetails(BarcodeRequest request) {
        return generateStub(request);
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

    private Medication generateStub(BarcodeRequest request) {
        return Medication.builder()
                .barcodeItem(this.mapBarCode(request, sessionMetadata))
                .expirationDate(LocalDateTime.now().plusDays(faker.number().numberBetween(1, 365)))
                .manufacturer(faker.company().name())
                .medicineName(faker.medical().medicineName())
                .dosage(faker.number().numberBetween(1, 100) + "mg")
                .build();
    }
}
