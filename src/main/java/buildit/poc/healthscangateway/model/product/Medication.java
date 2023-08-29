package buildit.poc.healthscangateway.model.product;

import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import java.time.LocalDateTime;

@ToString()
@Value()
@Builder()
public class Medication {
    BarcodeItem barcodeItem;
    String medicineName;
    String dosage;
    LocalDateTime expirationDate;
    String manufacturer;
}
