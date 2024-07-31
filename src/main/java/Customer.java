// Customer.java
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Customer implements Runnable {
    private int id;
    private Theatre selectedTheatre;
    private int[] selectedSeats;
    private List<Theatre> theatres;
    private Random random;

    public Customer(int id, List<Theatre> theatres) {
        this.id = id;
        this.theatres = theatres;
        this.random = new Random();
    }

    @Override
    public void run() {
        selectTheatreAndSeats();
        if (tryReserveSeats()) {
            try {
                // Simulate payment process
                Thread.sleep(random.nextInt(501) + 500);  // 500-1000ms delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            confirmReservation();
        } else {
            System.out.println("Customer " + id + " couldn't reserve seats");
        }
    }

    private void selectTheatreAndSeats() {
        selectedTheatre = theatres.get(random.nextInt(theatres.size()));
        int numSeats = random.nextInt(3) + 1;  // 1-3 seats
        List<Integer> seats = new ArrayList<>();
        while (seats.size() < numSeats) {
            int seat = random.nextInt(20);
            if (!seats.contains(seat)) {
                seats.add(seat);
            }
        }
        selectedSeats = seats.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean tryReserveSeats() {
        return selectedTheatre.tryReserveSeats(selectedSeats);
    }

    private void confirmReservation() {
        System.out.println("Customer " + id + " reserved seats " + 
                           java.util.Arrays.toString(selectedSeats) + 
                           " in theatre " + selectedTheatre.getTheatreNumber());
    }
}