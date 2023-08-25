package buildit.poc.healthscangateway.model.request;

import buildit.poc.healthscangateway.model.shared.BarcodeCategory;

public record BarcodeRequest(BarcodeCategory category, String barcode) {
}
