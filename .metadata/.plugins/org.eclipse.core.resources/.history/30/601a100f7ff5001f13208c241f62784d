package lab7;

import java.security.SecureRandom;

public class TorpedoStore {
    // Rate of failing to fire torpedos [0.0, 1.0]
    private double failureRate = 0.0;
    private int torpedoCount = 0;
    
    // Reuse SecureRandom instead of creating a new Random object each time
    private final SecureRandom random = new SecureRandom();

    public TorpedoStore(int numberOfTorpedos) {
        // Validate input
        if (numberOfTorpedos < 0) {
            throw new IllegalArgumentException("Initial torpedo count cannot be negative");
        }
        
        this.torpedoCount = numberOfTorpedos;

        // Update failure rate if it was specified in an environment variable
        String failureEnv = System.getenv("IVT_RATE");
        if (failureEnv != null) {
            try {
                failureRate = Double.parseDouble(failureEnv);
            } catch (NumberFormatException nfe) {
                failureRate = 0.0;
            }
        }
    }

    public boolean fire(int numberOfTorpedos) {
        if (numberOfTorpedos < 1 || numberOfTorpedos > this.torpedoCount) {
            throw new IllegalArgumentException("Invalid number of torpedos: " + numberOfTorpedos);
        }

        boolean success = false;

        // Simulate random overheating of the launcher bay which prevents firing
        double r = random.nextDouble();

        if (r >= failureRate) {
            // Successful firing - fixed the operator from =- to -=
            this.torpedoCount -= numberOfTorpedos; // fixhere
            success = true;
        } else {
            // Simulated failure
            success = false;
        }

        return success;
    }

    public boolean isEmpty() {
        return this.torpedoCount <= 0;
    }

    public int getTorpedoCount() {
        return this.torpedoCount;
    }
}