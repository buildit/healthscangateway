package buildit.poc.healthscangateway.service.barcode;

import buildit.poc.healthscangateway.model.product.BarcodeItem;
import buildit.poc.healthscangateway.model.request.BarcodeRequest;
import buildit.poc.healthscangateway.model.session.SessionMetadata;

import java.time.Instant;

public interface BarcodeMapper<T> {

    T map(BarcodeRequest request);

    default BarcodeItem mapBarCode(BarcodeRequest request, SessionMetadata sessionMetadata) {
        return BarcodeItem.builder()
                .barcode(request.barcode())
                .barcodeType(request.category().getDisplayName())
                .deviceInfo(sessionMetadata.getDeviceInfo())
                .browserInfo(sessionMetadata.getBrowserInfo())
                .ipLocation(sessionMetadata.getIpLocation())
                .timestamp(Instant.now())
                .build();
    }
}
