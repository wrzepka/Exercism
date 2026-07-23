public class LogLine {
    String logLine;
    
    public LogLine(String logLine) {
        this.logLine = logLine;
    }

    public LogLevel getLogLevel() {
        String parsedLogLevel = this.logLine.substring(1, this.logLine.indexOf(']')) ;

        switch (parsedLogLevel){
            case "TRC":
                return LogLevel.TRACE;
            case "DBG":
                return LogLevel.DEBUG;
            case "INF":
                return LogLevel.INFO;
            case "WRN":
                return LogLevel.WARNING;
            case "ERR":
                return LogLevel.ERROR;
            case "FTL":
                return LogLevel.FATAL;
            default:
                return LogLevel.UNKNOWN;
        }
    }

    public String getOutputForShortLog() {
        return getLogLevel().getIntLogLevel() + ":" + this.logLine.substring(this.logLine.indexOf(' ')+1);
    }
}
