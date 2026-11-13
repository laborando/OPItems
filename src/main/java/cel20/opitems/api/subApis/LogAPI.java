package cel20.opitems.api.subApis;

public interface LogAPI {

    /**
     * Logs a message through CLogger
     */
    void CLog(String message);

    /**
     * Triggers the debug Log through CLogger and writes it to the file
     */
    void triggerDebugLog();

}
