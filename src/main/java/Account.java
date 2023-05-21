import java.time.LocalDateTime;

public class Account {
    private int id;
    private String name;
    private String accountStanding;
    private boolean isActive;
    private LocalDateTime timeOfEntry;
    private int timeLeft;

    // Constructor
    public Account(int id, String name, String accountStanding, boolean isActive, LocalDateTime timeOfEntry, int timeLeft) {
        this.id = id;
        this.name = name;
        this.accountStanding = accountStanding;
        this.isActive = isActive;
        this.timeOfEntry = timeOfEntry;
        this.timeLeft = timeLeft;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountStanding() {
        return accountStanding;
    }

    public void setAccountStanding(String accountStanding) {
        this.accountStanding = accountStanding;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDateTime getTimeOfEntry() {
        return timeOfEntry;
    }

    public void setTimeOfEntry(LocalDateTime timeOfEntry) {
        this.timeOfEntry = timeOfEntry;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }
}