package buildit.poc.healthscangateway.service.uhg;

import buildit.poc.healthscangateway.model.exception.UGHGatewayAPIServiceException;
import buildit.poc.healthscangateway.model.product.LabKit;
import buildit.poc.healthscangateway.model.product.Medication;
import buildit.poc.healthscangateway.model.product.WasteDisposalKit;
import buildit.poc.healthscangateway.service.uhg.model.UHGApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UHGGatewayAPIService {
    private static final String UHG_API_URL = "https://api.uhg.com/save"; // blah blah whatever it ends up being

    public UHGApiResponse saveMedicationToUHG(Medication scannedItem) throws UGHGatewayAPIServiceException {
        try {
            log.info("save medication to uhg: {}", scannedItem);
        } catch (Exception e) {
            throw new UGHGatewayAPIServiceException("Error saving medication to UHG: %s".formatted(scannedItem), e);
        }
        return new UHGApiResponse("Success", "ConfirmationCode123");
    }

    public UHGApiResponse saveLabKitToUHG(LabKit scannedItem) throws UGHGatewayAPIServiceException {
        try {
            log.info("save lab kit to uhg: {}", scannedItem);
        } catch (Exception e) {
            throw new UGHGatewayAPIServiceException("Error saving medication to UHG: %s".formatted(scannedItem), e);
        }
        return new UHGApiResponse("Success", "ConfirmationCode123");
    }

    public UHGApiResponse saveWasteDisposalKitToUHG(WasteDisposalKit scannedItem) throws UGHGatewayAPIServiceException {
        try {
            log.info("save waste disposal kit to uhg: {}", scannedItem);
        } catch (Exception e) {
            throw new UGHGatewayAPIServiceException("Error saving medication to UHG: %s".formatted(scannedItem), e);
        }
        return new UHGApiResponse("Success", "ConfirmationCode123");
    }
}
