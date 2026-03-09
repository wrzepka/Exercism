using System.Runtime.InteropServices;
using System.Globalization;

public enum Location
{
    NewYork,
    London,
    Paris
}

public enum AlertLevel
{
    Early,
    Standard,
    Late
}

public static class Appointment
{
    public static DateTime ShowLocalTime(DateTime dtUtc)
    {
        return dtUtc.ToLocalTime();
    }

    public static DateTime Schedule(string appointmentDateDescription, Location location)
    {
        DateTime dTime = DateTime.Parse(appointmentDateDescription);

        TimeZoneInfo tst = TimeZoneInfo.FindSystemTimeZoneById("Eastern Standard Time");
        
        if (RuntimeInformation.IsOSPlatform(OSPlatform.Windows)){
            switch (location){
                case Location.NewYork:
                    tst = TimeZoneInfo.FindSystemTimeZoneById("Eastern Standard Time");
                    break;
                case Location.London:
                    tst = TimeZoneInfo.FindSystemTimeZoneById("GMT Standard Time");
                    break;
                case Location.Paris:
                    tst = TimeZoneInfo.FindSystemTimeZoneById("W. Europe Standard Time");
                    break;
            }
        }else{
            switch (location){
                case Location.NewYork:
                    tst = TimeZoneInfo.FindSystemTimeZoneById("America/New_York");
                    break;
                case Location.London:
                    tst = TimeZoneInfo.FindSystemTimeZoneById("Europe/London");
                    break;
                case Location.Paris:
                    tst = TimeZoneInfo.FindSystemTimeZoneById("Europe/Paris");
                    break;
            }
        }

        DateTime targetTime = TimeZoneInfo.ConvertTimeToUtc(dTime, tst);

        return targetTime;
    }

    public static DateTime GetAlertTime(DateTime appointment, AlertLevel alertLevel)
    {
        switch (alertLevel){
            case AlertLevel.Early:
                appointment = appointment - TimeSpan.FromDays(1);
                break;
            case AlertLevel.Standard:
                appointment = appointment - TimeSpan.FromHours(1);
                appointment = appointment - TimeSpan.FromMinutes(45);
                break;
            case AlertLevel.Late:
                appointment = appointment - TimeSpan.FromMinutes(30);
                break;
        }

        return appointment;
    }

    public static bool HasDaylightSavingChanged(DateTime dt, Location location)
    {
        TimeZoneInfo tst = TimeZoneInfo.FindSystemTimeZoneById("Eastern Standard Time");
        
        if (RuntimeInformation.IsOSPlatform(OSPlatform.Windows)){
            switch (location){
                case Location.NewYork:
                    tst = TimeZoneInfo.FindSystemTimeZoneById("Eastern Standard Time");
                    break;
                case Location.London:
                    tst = TimeZoneInfo.FindSystemTimeZoneById("GMT Standard Time");
                    break;
                case Location.Paris:
                    tst = TimeZoneInfo.FindSystemTimeZoneById("W. Europe Standard Time");
                    break;
            }
        }else{
            switch (location){
                case Location.NewYork:
                    tst = TimeZoneInfo.FindSystemTimeZoneById("America/New_York");
                    break;
                case Location.London:
                    tst = TimeZoneInfo.FindSystemTimeZoneById("Europe/London");
                    break;
                case Location.Paris:
                    tst = TimeZoneInfo.FindSystemTimeZoneById("Europe/Paris");
                    break;
            }
        }
        
        return tst.IsDaylightSavingTime(dt) != tst.IsDaylightSavingTime(dt - TimeSpan.FromDays(7));
    }

    public static DateTime NormalizeDateTime(string dtStr, Location location)
    {
        string cultureName = "en-GB";

        switch (location){
            case Location.NewYork:
                cultureName = "en-US";
                break;
            case Location.London:
                cultureName = "en-GB";
                break;
            case Location.Paris:
                cultureName = "fr-FR";
                break;
        }

        CultureInfo culture = new CultureInfo(cultureName);

        if (DateTime.TryParse(dtStr, culture, out DateTime result)) return result;
        return new DateTime(1, 1, 1);
    }
}
