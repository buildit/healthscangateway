package buildit.poc.healthscangateway.service.barcode;

import buildit.poc.healthscangateway.model.exception.UGHGatewayAPIServiceException;
import buildit.poc.healthscangateway.model.exception.WasteDisposalKitException;
import buildit.poc.healthscangateway.model.product.WasteDisposalKit;
import buildit.poc.healthscangateway.model.request.BarcodeRequest;
import buildit.poc.healthscangateway.model.session.SessionMetadata;
import buildit.poc.healthscangateway.model.tracking.TrackingInfo;
import buildit.poc.healthscangateway.service.uhg.UHGGatewayAPIService;
import buildit.poc.healthscangateway.service.uhg.model.UHGApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WasteDisposalKitService implements BarcodeService, BarcodeMapper<WasteDisposalKit> {

    private final UHGGatewayAPIService uhgGatewayAPIService;
    private final SessionMetadata sessionMetadata;

    @Override
    public UHGApiResponse scanAndSave(BarcodeRequest request) throws UGHGatewayAPIServiceException {
        return uhgGatewayAPIService.saveWasteDisposalKitToUHG(this.map(request));
    }

    @Override
    public void onError(Exception e) throws WasteDisposalKitException {
        String message = "An error occurred while processing the waste disposal kit: %s".formatted(e.getMessage());
        throw new WasteDisposalKitException(message, e);
    }

    @Override
    public WasteDisposalKit map(BarcodeRequest request) {
        return WasteDisposalKit.builder()
                .barcodeItem(this.mapBarCode(request, sessionMetadata))
                .kitType("Manufacturer")
                .contents(List.of("Content 1", "Content 2"))
                .disposalInstructions("Disposal Instructions")
                .handlingWarnings("Handling Warnings")
                .trackingInfo(new TrackingInfo("Tracking Number", "Status", "Courier"))
                .build();
    }
}
