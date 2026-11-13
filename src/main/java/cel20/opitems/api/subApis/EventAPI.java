package cel20.opitems.api.subApis;

public interface EventAPI {
    /**
     * Disables <b>ALL</b> events managed by OPItems
     */
    void disableEvents();

    /**
     * Re-enables events  managed by OPItems
     */
    void enableEvent();

    /**
     * @return true if events are disabled
     */
    boolean eventsEnabled();

}
