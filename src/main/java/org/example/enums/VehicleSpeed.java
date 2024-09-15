package org.example.enums;

import org.example.exceptions.ExceedingMaxSpeedException;

public enum VehicleSpeed {
    SLOW(50),
    MODERATE(100),
    FAST(150),
    EXTREME(200);

    private final int maxSpeed;

    VehicleSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void checkSpeed(int speed) throws ExceedingMaxSpeedException {
        if (speed > maxSpeed) {
            throw new ExceedingMaxSpeedException("Speed exceeds the limit for " + name() + ": " + maxSpeed);
        }
    }

}

