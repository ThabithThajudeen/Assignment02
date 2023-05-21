import java.util.ArrayList;
import java.util.List;

 public class Bus {
        private int id;
        private boolean onTime;
        private double latitude;
        private double longitude;

        //private List<Observer> observers = new ArrayList<>();

        public Bus(int id, boolean onTime, double latitude, double longitude) {
            this.id = id;
            this.onTime = onTime;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        //  private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isOnTime() {
            return onTime;
        }

        public void setOnTime(boolean onTime) {
            this.onTime = onTime;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }




    }
