package buildit.poc.healthscangateway.controller.barcode;

import buildit.poc.healthscangateway.model.request.BarcodeRequest;
import buildit.poc.healthscangateway.model.response.WrapperResponse;
import buildit.poc.healthscangateway.service.barcode.BarcodeService;
import buildit.poc.healthscangateway.service.barcode.BarcodeServiceFactory;
import buildit.poc.healthscangateway.service.uhg.model.UHGAPIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/barcode")
public class BarcodeController {

    private final BarcodeServiceFactory barcodeServiceFactory;

    @PostMapping("/scan")
    public ResponseEntity<WrapperResponse<UHGAPIResponse>> scanBarcode(@RequestBody BarcodeRequest request) {
        try {
            BarcodeService service = barcodeServiceFactory.getService(request.category());
            UHGAPIResponse response = service.scanAndSave(request);
            return ResponseEntity.ok(new WrapperResponse<>(response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new WrapperResponse<>(e.getMessage()));
        }
    }
}
