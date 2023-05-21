//package org.example;
    import java.time.LocalDateTime;

    public class Passenger {
        private int accountNumber;
        private String name;
        private String accountStanding;
        private boolean onboard;
        private LocalDateTime timeOfEntry;
        private LocalDateTime timeOfLeft;
        private int busId;
        private int trainId;

        public Passenger(int accountNumber, String name, String accountStanding, boolean onboard,
                         LocalDateTime timeOfEntry, LocalDateTime timeOfLeft, int busId, int trainId) {
            this.accountNumber = accountNumber;
            this.name = name;
            this.accountStanding = accountStanding;
            this.onboard = onboard;
            this.timeOfEntry = timeOfEntry;
            this.timeOfLeft = timeOfLeft;
            this.busId = busId;
            this.trainId = trainId;
        }

        // Getters and Setters for the fields

        public int getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(int accountNumber) {
            this.accountNumber = accountNumber;
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

        public boolean isOnboard() {
            return (busId != -1) || (trainId != -1);
        }

        public void setOnboard(boolean onboard) {
            this.onboard = onboard;
        }

        public LocalDateTime getTimeOfEntry() {
            return timeOfEntry;
        }

        public void setTimeOfEntry(LocalDateTime timeOfEntry) {
            this.timeOfEntry = timeOfEntry;
        }

        public LocalDateTime getTimeOfLeft() {
            return timeOfLeft;
        }

        public void setTimeOfLeft(LocalDateTime timeOfLeft) {
            this.timeOfLeft = timeOfLeft;
        }

        public int getBusId() {
            return busId;
        }

        public void setBusId(int busId) {
            this.busId = busId;
        }

        public int getTrainId() {
            return trainId;
        }

        public void setTrainId(int trainId) {
            this.trainId = trainId;
        }
}
