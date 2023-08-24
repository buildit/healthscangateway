package buildit.poc.healthscangateway.filter;

import buildit.poc.healthscangateway.model.metadata.BrowserInfo;
import buildit.poc.healthscangateway.model.metadata.DeviceInfo;
import buildit.poc.healthscangateway.model.metadata.IPLocation;
import buildit.poc.healthscangateway.model.session.SessionMetadata;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ua_parser.Client;
import ua_parser.Parser;

import java.io.IOException;

@Component
public class MetadataFilter extends OncePerRequestFilter {

    private final SessionMetadata sessionMetadata;
    private final Parser uaParser;

    public MetadataFilter(SessionMetadata sessionMetadata) {
        this.sessionMetadata = sessionMetadata;
        this.uaParser = new Parser();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Client client = uaParser.parse(request.getHeader("User-Agent"));

        BrowserInfo browserInfo = new BrowserInfo(client.userAgent.family, client.userAgent.major + "." + client.userAgent.minor);
        DeviceInfo deviceInfo = new DeviceInfo(client.device.family);
        IPLocation ipLocation = new IPLocation(request.getRemoteAddr());

        sessionMetadata.setBrowserInfo(browserInfo);
        sessionMetadata.setDeviceInfo(deviceInfo);
        sessionMetadata.setIpLocation(ipLocation);

        filterChain.doFilter(request, response);
    }
}
