package org.example.utils;

import com.google.inject.Singleton;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

@Log4j2
@Getter
@ToString
@Singleton
public class PropertyHolder {

    public static final String SYSTEM_PROPERTY = "property.properties";

    private final String deviceName;
    private final String platformVersion;
    private final String platformName;
    private final String app;
    private final String automationName;
    private final String appPackage;
    private final String appWaitActivity;
    private final String fullReset;
    private final String clearSystemFiles;
    private final String noReset;
    private final String udid;
    private final String newCommandTimeout;

    private final Properties properties = new Properties();

    @SneakyThrows
    public PropertyHolder() {
        URL resource = Thread.currentThread().getContextClassLoader().getResource(SYSTEM_PROPERTY);
        if (resource != null) {
            try (InputStream stream = new FileInputStream(resource.getPath())) {
                properties.load(stream);
                log.info(SYSTEM_PROPERTY + " is loaded");
            }
        } else {
            log.warn(SYSTEM_PROPERTY + " is not found");
        }

        this.deviceName = getNormalizedProperty("device_name");
        this.platformVersion = getNormalizedProperty("platform_version");
        this.platformName = getNormalizedProperty("platform_name");
        this.app = getNormalizedProperty("app");
        this.automationName = getNormalizedProperty("automation_name");
        this.appPackage = getNormalizedProperty("app_package");
        this.appWaitActivity = getNormalizedProperty("app_wait_activity");
        this.fullReset = getNormalizedProperty("full_reset");
        this.clearSystemFiles = getNormalizedProperty("clear_system_files");
        this.noReset = getNormalizedProperty("no_reset");
        this.udid = getNormalizedProperty("udid");
        this.newCommandTimeout = getNormalizedProperty("new_command_timeout");
    }

    private String getNormalizedProperty(String key) {
        String value = System.getProperty(key);
        if (value == null || value.trim().isEmpty()) {
            return properties.getProperty(key);
        }
        return value;
    }

}
