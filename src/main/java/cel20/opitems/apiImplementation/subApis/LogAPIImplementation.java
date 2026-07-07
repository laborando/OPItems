package cel20.opitems.apiImplementation.subApis;

import cel20.opitems.api.subApis.LogAPI;
import cel20.opitems.utis.CLogger;
import cel20.opitems.utis.Logutis;

public class LogAPIImplementation implements LogAPI {
    @Override
    public void CLog(String message) {
        CLogger.log(message);
    }

    @Override
    public void triggerDebugLog() {
        Logutis.createReportAndLog();
    }
}
