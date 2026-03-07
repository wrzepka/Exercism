using System.Text;
public static class Identifier
{
    public static string Clean(string identifier)
    {
        StringBuilder strBuilder = new StringBuilder();

        for (int i = 0; i < identifier.Length; i++)
        {
            if (identifier[i] == ' ')
            {
                strBuilder.Append('_');
            }
            else if (identifier[i] == '-' && i + 1 < identifier.Length){
                strBuilder.Append(Char.ToUpper(identifier[i+1]));
                i++;
            }
            else if (identifier[i] == '\0'){
                strBuilder.Append("CTRL");
            }
            else if (char.IsLetter(identifier[i]) && (identifier[i] < 'α' || identifier[i] > 'ω')){
                strBuilder.Append(identifier[i]);
            }
        }
        return strBuilder.ToString();
    }
}
