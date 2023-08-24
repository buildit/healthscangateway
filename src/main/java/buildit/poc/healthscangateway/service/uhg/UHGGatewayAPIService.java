package buildit.poc.healthscangateway.service.uhg;

import buildit.poc.healthscangateway.model.product.LabKit;
import buildit.poc.healthscangateway.model.product.Medication;
import buildit.poc.healthscangateway.model.product.WasteDisposalKit;
import buildit.poc.healthscangateway.service.uhg.model.UHGAPIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UHGGatewayAPIService {
    private static final String UHG_API_URL = "https://api.uhg.com/save"; // blah blah whatever it ends up being

    public UHGAPIResponse saveMedicationToUHG(Medication scannedItem) {
        log.info("save medication to uhg: {}", scannedItem);
        return new UHGAPIResponse("Success", "ConfirmationCode123");
    }

    public UHGAPIResponse saveLabKitToUHG(LabKit scannedItem) {
        log.info("save lab kit to uhg: {}", scannedItem);
        return new UHGAPIResponse("Success", "ConfirmationCode123");
    }

    public UHGAPIResponse saveWasteDisposalKitToUHG(WasteDisposalKit scannedItem) {
        log.info("save waste disposal kit to uhg: {}", scannedItem);
        return new UHGAPIResponse("Success", "ConfirmationCode123");
    }
}
