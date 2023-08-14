package org.example.driverProvider;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static java.util.Arrays.stream;

@Getter
@RequiredArgsConstructor
public enum DriverTypes {
    // TODO: Can be extended for other platform

    ANDROID(new AndroidDriverInvoker());

    private final DriverInvoker driver;

    private static final DriverTypes[] VALUES = values();

    public static DriverInvoker getDriverInvoker(String driverType) {
        return stream(VALUES)
                .filter(e -> e.name().equalsIgnoreCase(driverType))
                .map(DriverTypes::getDriver)
                .findFirst()
                .orElse(null);
    }
}
