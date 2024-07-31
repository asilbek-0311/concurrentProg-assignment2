// CinemaReservationSystem.java
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CinemaReservationSystem {
    private static final int NUM_THEATRES = 3;
    private static final int NUM_CUSTOMERS = 100;

    public static void main(String[] args) {
        // Initialize theatres
        List<Theatre> theatres = new ArrayList<>();
        for (int i = 0; i < NUM_THEATRES; i++) {
            theatres.add(new Theatre(i + 1));
        }

        // Create and start customer threads
        ExecutorService executor = Executors.newFixedThreadPool(NUM_CUSTOMERS);
        for (int i = 0; i < NUM_CUSTOMERS; i++) {
            executor.execute(new Customer(i + 1, theatres));
        }

        // Shutdown executor and wait for all threads to finish
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Print final seat allocations
        printFinalAllocations(theatres);
    }

    private static void printFinalAllocations(List<Theatre> theatres) {
        System.out.println("\nFinal Seat Allocations:");
        for (Theatre theatre : theatres) {
            System.out.println("Theatre " + theatre.getTheatreNumber() + ": " + theatre.getSeatsStatus());
        }
    }
}