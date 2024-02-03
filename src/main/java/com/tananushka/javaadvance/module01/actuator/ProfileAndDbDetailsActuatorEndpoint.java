package com.tananushka.javaadvance.module01.actuator;

import com.tananushka.javaadvance.module01.dto.ProfileAndDbDetailsActuatorResponse;
import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "profile-db-details")
@AllArgsConstructor
public class ProfileAndDbDetailsActuatorEndpoint {

    private final Environment environment;
    private final DataSourceProperties dataSourceProperties;

    @ReadOperation
    public ProfileAndDbDetailsActuatorResponse profileAndDbDetailsActuatorData() {
        String activeProfiles = String.join(", ", environment.getActiveProfiles());
        String dbUrl = dataSourceProperties.getUrl();
        return new ProfileAndDbDetailsActuatorResponse(activeProfiles, dbUrl);
    }
}
