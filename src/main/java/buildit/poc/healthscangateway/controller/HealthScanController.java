package buildit.poc.healthscangateway.controller;

import buildit.poc.healthscangateway.error.HealthScanError;
import buildit.poc.healthscangateway.model.Med;
import buildit.poc.healthscangateway.model.Tool;
import buildit.poc.healthscangateway.model.Waste;
import buildit.poc.healthscangateway.service.HealthScanGatewayService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/healthscan")
@AllArgsConstructor
public class HealthScanController {
    private HealthScanGatewayService gatewayService;
    @ExceptionHandler({ HealthScanError.class })
    public void handleException() {
        //
    }
    @PostMapping("/med")
    @ResponseBody
    public void updateMed(Med med) {
        gatewayService.updateMed(med);
    }

    @PostMapping("/tool")
    @ResponseBody
    public void updateTool(Tool tool) {
        gatewayService.updateTool(tool);
    }

    @PostMapping("/waste")
    @ResponseBody
    public void updateWaste(Waste waste) {
        gatewayService.updateWaste(waste);
    }

}
