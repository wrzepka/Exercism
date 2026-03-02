public static class LogAnalysis 
{
    // TODO: define the 'SubstringAfter()' extension method on the `string` type
    public static string SubstringAfter(this string logMsg, string targetStr)
    {
        int targetStrLen = targetStr.Length;
        int targetStrStartIndex = logMsg.IndexOf(targetStr);

        int targetStrEndIndex = targetStrLen + targetStrStartIndex;
        
        return logMsg.Substring(targetStrEndIndex);
    }
    // TODO: define the 'SubstringBetween()' extension method on the `string` type
    public static string SubstringBetween(this string logMsg, string StartStr, string EndStr)
    {
        int StartStrLen = StartStr.Length;
        int StartStrIndex = logMsg.IndexOf(StartStr);
        int StartStrEndIndex = StartStrLen + StartStrIndex;

        int EndStrIndex = logMsg.IndexOf(EndStr);

        int BetweenLen = EndStrIndex - StartStrEndIndex;
        
        return logMsg.Substring(StartStrEndIndex, BetweenLen);
    }
    // TODO: define the 'Message()' extension method on the `string` type
    public static string Message(this string logMsg) => logMsg.SubstringAfter(": ");
    // TODO: define the 'LogLevel()' extension method on the `string` type
    public static string LogLevel(this string logMsg) => logMsg.SubstringBetween("[", "]");
}