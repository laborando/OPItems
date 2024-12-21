package cmd.filters;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.message.Message;

import java.util.logging.LogRecord;

public class SummonFilter implements Filter {

    public boolean isEnabled = true;

    public void disable(){
        isEnabled = false;
    }

    @Override
    public State getState() {
        return null;
    }

    @Override
    public void initialize() {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isStarted() {
        return false;
    }

    @Override
    public boolean isStopped() {
        return false;
    }

    @Override
    public org.apache.logging.log4j.core.Filter.Result filter(LogEvent event) {
        //disable jaja
        if(!isEnabled)
            return null;



        if (event.getMessage().toString().toLowerCase().contains("summoned")) {
            return org.apache.logging.log4j.core.Filter.Result.DENY;
        }else {
            return org.apache.logging.log4j.core.Filter.Result.DENY;
        }
        //return null;
    }
    public org.apache.logging.log4j.core.Filter.Result filter(org.apache.logging.log4j.Logger arg0, java.util.logging.Level arg1, Marker arg2, String arg3, Object... arg4) {
        return null;
    }
    public Result filter(org.apache.logging.log4j.Logger arg0, java.util.logging.Level arg1, Marker arg2, Object arg3, Throwable arg4) {
        return null;
    }
    public Result filter(org.apache.logging.log4j.Logger arg0, java.util.logging.Level arg1, Marker arg2, Message arg3, Throwable arg4) {
        return null;
    }
    @Override
    public Result getOnMatch() {
        return null;
    }

    @Override
    public Result filter(org.apache.logging.log4j.core.Logger logger, org.apache.logging.log4j.Level level, Marker marker, String s, Object... objects) {
        return null;
    }

    @Override
    public Result filter(org.apache.logging.log4j.core.Logger logger, org.apache.logging.log4j.Level level, Marker marker, String s, Object o) {
        return null;
    }

    @Override
    public Result filter(org.apache.logging.log4j.core.Logger logger, org.apache.logging.log4j.Level level, Marker marker, String s, Object o, Object o1) {
        return null;
    }

    @Override
    public Result filter(org.apache.logging.log4j.core.Logger logger, org.apache.logging.log4j.Level level, Marker marker, String s, Object o, Object o1, Object o2) {
        return null;
    }

    @Override
    public Result filter(org.apache.logging.log4j.core.Logger logger, org.apache.logging.log4j.Level level, Marker marker, String s, Object o, Object o1, Object o2, Object o3) {
        return null;
    }

    @Override
    public Result filter(org.apache.logging.log4j.core.Logger logger, org.apache.logging.log4j.Level level, Marker marker, String s, Object o, Object o1, Object o2, Object o3, Object o4) {
        return null;
    }

    @Override
    public Result filter(org.apache.logging.log4j.core.Logger logger, org.apache.logging.log4j.Level level, Marker marker, String s, Object o, Object o1, Object o2, Object o3, Object o4, Object o5) {
        return null;
    }

    @Override
    public Result filter(org.apache.logging.log4j.core.Logger logger, org.apache.logging.log4j.Level level, Marker marker, String s, Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6) {
        return null;
    }

    @Override
    public Result filter(org.apache.logging.log4j.core.Logger logger, org.apache.logging.log4j.Level level, Marker marker, String s, Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7) {
        return null;
    }

    @Override
    public Result filter(org.apache.logging.log4j.core.Logger logger, org.apache.logging.log4j.Level level, Marker marker, String s, Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8) {
        return null;
    }

    @Override
    public Result filter(org.apache.logging.log4j.core.Logger logger, org.apache.logging.log4j.Level level, Marker marker, String s, Object o, Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9) {
        return null;
    }

    @Override
    public Result filter(org.apache.logging.log4j.core.Logger logger, org.apache.logging.log4j.Level level, Marker marker, Object o, Throwable throwable) {
        return null;
    }

    @Override
    public Result filter(org.apache.logging.log4j.core.Logger logger, org.apache.logging.log4j.Level level, Marker marker, Message message, Throwable throwable) {
        return null;
    }

    @Override
    public Result getOnMismatch() {
        return null;
    }
}

