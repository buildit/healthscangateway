package buildit.poc.healthscangateway.model.session;

import buildit.poc.healthscangateway.model.metadata.BrowserInfo;
import buildit.poc.healthscangateway.model.metadata.DeviceInfo;
import buildit.poc.healthscangateway.model.metadata.IPLocation;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Data
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionMetadata {
    private BrowserInfo browserInfo;
    private DeviceInfo deviceInfo;
    private IPLocation ipLocation;
}
