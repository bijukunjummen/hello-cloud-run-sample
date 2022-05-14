package org.bk.logback.custom;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.contrib.json.classic.JsonLayout;
import com.google.cloud.logging.Severity;

import java.util.Map;

public class GcpJsonLayout extends JsonLayout {
    private static final String SEVERITY_FIELD = "severity";

    @Override
    protected void addCustomDataToJsonMap(Map<String, Object> map, ILoggingEvent event) {
        map.put(SEVERITY_FIELD, severityFor(event.getLevel()));
    }

    private static Severity severityFor(Level level) {
        return switch (level.toInt()) {
            // TRACE
            case 5000 -> Severity.DEBUG;
            // DEBUG
            case 10000 -> Severity.DEBUG;
            // INFO
            case 20000 -> Severity.INFO;
            // WARNING
            case 30000 -> Severity.WARNING;
            // ERROR
            case 40000 -> Severity.ERROR;
            default -> Severity.DEFAULT;
        };
    }
}
