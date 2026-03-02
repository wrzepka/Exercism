static class Badge
{
    public static string Print(int? id, string name, string? department)
    {
        string idCheck = "";
        if (id != null){
            idCheck = $"[{id}] - ";
        }
        string deparmentCheck = department ?? "OWNER";
        
        return $"{idCheck}{name} - {deparmentCheck.ToUpper()}";
    }
}
