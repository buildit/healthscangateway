package buildit.poc.healthscangateway.service.barcode;

import buildit.poc.healthscangateway.model.shared.BarcodeCategory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BarcodeServiceFactory {
    private final MedicationService medicationService;

    private final LabKitService labKitService;

    private final WasteDisposalKitService wasteDisposalKitService;

    public BarcodeService<?> getService(BarcodeCategory category) {
        return switch (category) {
            case MEDICATION -> medicationService;
            case LAB_KIT -> labKitService;
            case WASTE_DISPOSAL_KIT -> wasteDisposalKitService;
        };
    }
}
