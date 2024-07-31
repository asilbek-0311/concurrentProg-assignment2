import java.util.concurrent.locks.ReentrantLock;

public class Theatre {
    private boolean[] seats;
    private ReentrantLock lock;
    private int theatreNumber;

    public Theatre(int theatreNumber) {
        this.theatreNumber = theatreNumber;
        this.seats = new boolean[20];  // Initialize 20 seats, all false (available)
        this.lock = new ReentrantLock();
    }

    public boolean tryReserveSeats(int[] selectedSeats) {
        lock.lock();
        try {
            // Check if all selected seats are available
            for (int seat : selectedSeats) {
                if (seats[seat]) {
                    return false;  // Seat already taken
                }
            }
            // Reserve all selected seats
            for (int seat : selectedSeats) {
                seats[seat] = true;
            }
            return true;
        } finally {
            lock.unlock();
        }
    }

    public int getTheatreNumber() {
        return theatreNumber;
    }

    public String getSeatsStatus() {
        StringBuilder status = new StringBuilder();
        for (int i = 0; i < seats.length; i++) {
            status.append(seats[i] ? "X" : "O");
        }
        return status.toString();
    }
}