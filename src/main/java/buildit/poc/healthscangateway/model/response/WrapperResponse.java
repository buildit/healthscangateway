package buildit.poc.healthscangateway.model.response;

import lombok.Data;

@Data
public class WrapperResponse {
    private final String status;
    private final Object data;
    private final String message;

    public WrapperResponse(ConfirmationResponse confirmation) {
        this.status = "success";
        this.data = confirmation;
        this.message = "Operation successful";
    }

    public WrapperResponse(String errorMessage) {
        this.status = "error";
        this.data = null;
        this.message = errorMessage;
    }
}
