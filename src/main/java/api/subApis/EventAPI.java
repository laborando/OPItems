package api.subApis;

public interface EventAPI {
    /**
     * Disables <b>ALL</b> events
     */
    public void disableEvents();

    /**
     * Re-enables events
     */
    public void enableEvent();

    /**
     * @return true if events are disabled
     */
    public boolean eventsDisabled();
}
