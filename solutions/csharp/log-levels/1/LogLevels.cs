static class LogLine
{
    public static string Message(string logLine)
    {
        int colonIndex = logLine.IndexOf(":");
        string modifiedMessage = logLine.Remove(0, ++colonIndex).Trim();
    
        return modifiedMessage;
    }

    public static string LogLevel(string logLine)
    {
        int levelStartIndex = logLine.IndexOf("[");
        int levelEndIndex = logLine.IndexOf("]");

        string modifiedMessage = logLine.Substring(++levelStartIndex, --levelEndIndex).ToLower();

        return modifiedMessage;
    }

    public static string Reformat(string logLine)
    {
        string modifiedMessage = Message(logLine) + $" ({LogLevel(logLine)})";
            
        return modifiedMessage;
    }
}
