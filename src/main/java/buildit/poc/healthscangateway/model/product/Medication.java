package buildit.poc.healthscangateway.model.product;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@ToString()
@Value()
@Builder()
public class Medication {
    BarcodeItem barcodeItem;
    String medicineName;
    String dosage;
    String expirationDate;
    String manufacturer;
}
