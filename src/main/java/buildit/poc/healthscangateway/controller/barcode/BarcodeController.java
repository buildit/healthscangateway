package buildit.poc.healthscangateway.controller.barcode;

import buildit.poc.healthscangateway.model.request.BarcodeRequest;
import buildit.poc.healthscangateway.model.response.WrapperResponse;
import buildit.poc.healthscangateway.model.shared.BarcodeCategory;
import buildit.poc.healthscangateway.service.barcode.BarcodeService;
import buildit.poc.healthscangateway.service.barcode.BarcodeServiceFactory;
import buildit.poc.healthscangateway.service.uhg.model.UHGApiResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/barcode")
public class BarcodeController {

    private final BarcodeServiceFactory barcodeServiceFactory;

    @PostMapping("/create")
    public ResponseEntity<WrapperResponse<UHGApiResponse>> scanBarcode(@RequestBody BarcodeRequest request) {
        try {
            BarcodeService<?> service = barcodeServiceFactory.getService(request.category());
            UHGApiResponse response = service.scanAndSave(request);
            return ResponseEntity.ok(new WrapperResponse<>(response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new WrapperResponse<>(e.getMessage()));
        }
    }

    @GetMapping("/details/{barcodeCategory}")
    public ResponseEntity<WrapperResponse<Object>> getBarcodeDetails(
            @Schema(allowableValues = {"Medication", "Lab Kit", "Waste Disposal Kit"},
                    example = "Medication",
                    description = "Category of the barcode") @PathVariable("barcodeCategory") String barcodeCategory,
            @RequestParam("barcode") String barcode) {
        try {
            BarcodeService<?> service = barcodeServiceFactory.getService(BarcodeCategory.valueOfDisplayName(barcodeCategory));
            Object details = service.getBarcodeDetails(new BarcodeRequest(BarcodeCategory.valueOfDisplayName(barcodeCategory), barcode));
            return ResponseEntity.ok(new WrapperResponse<>(details));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new WrapperResponse<>(e.getMessage()));
        }
    }
}
