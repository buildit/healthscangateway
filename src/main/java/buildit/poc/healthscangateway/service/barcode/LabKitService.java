package buildit.poc.healthscangateway.service.barcode;

import buildit.poc.healthscangateway.model.product.LabKit;
import buildit.poc.healthscangateway.model.request.BarcodeRequest;
import buildit.poc.healthscangateway.model.response.ConfirmationResponse;
import buildit.poc.healthscangateway.model.session.SessionMetadata;
import buildit.poc.healthscangateway.service.uhg.UHGGatewayAPIService;
import buildit.poc.healthscangateway.service.uhg.model.UHGAPIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class LabKitService implements BarcodeService, BarcodeMapper<LabKit> {

    private final UHGGatewayAPIService uhgGatewayAPIService;
    private final SessionMetadata sessionMetadata;

    @Override
    public ConfirmationResponse scanAndSave(BarcodeRequest request) {
        UHGAPIResponse uhgResponse = uhgGatewayAPIService.saveLabKitToUHG(this.map(request));
        return new ConfirmationResponse(uhgResponse);
    }

    @Override
    public LabKit map(BarcodeRequest request) {
        return LabKit.builder()
                .barcodeItem(this.mapBarCode(request, sessionMetadata))
                .kitName("Lab Kit")
                .components(Arrays.asList("Component 1", "Component 2", "Component 3"))
                .instructions("Instructions")
                .manufacturer("Manufacturer")
                .intendedUse("Intended Use")
                .uhgAPIInfo(null)
                .build();
    }
}
