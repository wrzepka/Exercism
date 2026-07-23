public enum LogLevel {
    TRACE(1),
    DEBUG(2),
    INFO(4),
    WARNING(5),
    ERROR(6),
    FATAL(42),
    UNKNOWN(0);

    private final int intLogLevel;

    LogLevel(int intLogLevel){
        this.intLogLevel = intLogLevel;
    }

    public int getIntLogLevel(){
        return this.intLogLevel;
    }
}
