static class LogLine
{
    public static string Message(string logLine)
    {
        int colonIndex = logLine.IndexOf(":");
        
        return logLine.Remove(0, ++colonIndex).Trim();
    }

    public static string LogLevel(string logLine)
    {
        int levelStartIndex = logLine.IndexOf("[");
        int levelEndIndex = logLine.IndexOf("]");
        
        return logLine.Substring(++levelStartIndex, --levelEndIndex).ToLower();
    }

    public static string Reformat(string logLine)
    {  
        return Message(logLine) + $" ({LogLevel(logLine)})";
    }
}
