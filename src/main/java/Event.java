
    public class Event {
        private int eventId;
        private String eventType;
        private String entityId;
        private String eventTime;

        // Constructor
        public Event(int eventId, String eventType, String entityId, String eventTime) {
            this.eventId = eventId;
            this.eventType = eventType;
            this.entityId = entityId;
            this.eventTime = eventTime;
        }

        // Getters and Setters
        public int getEventId() {
            return eventId;
        }

        public void setEventId(int eventId) {
            this.eventId = eventId;
        }

        public String getEventType() {
            return eventType;
        }

        public void setEventType(String eventType) {
            this.eventType = eventType;
        }

        public String getEntityId() {
            return entityId;
        }

        public void setEntityId(String entityId) {
            this.entityId = entityId;
        }

        public String getEventTime() {
            return eventTime;
        }

        public void setEventTime(String eventTime) {
            this.eventTime = eventTime;
        }
    }
