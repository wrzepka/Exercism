import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
    
class AppointmentScheduler {
    public LocalDateTime schedule(String appointmentDateDescription) {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        return LocalDateTime.parse(appointmentDateDescription, parser);
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        if (appointmentDate.isAfter(LocalDateTime.now())) return false;
        return true;
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        int hour = appointmentDate.getHour();
        if (hour >= 12 && hour < 18) return true;
        return false;
    }

    public String getDescription(LocalDateTime appointmentDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("'You have an appointment on' EEEE, MMMM d, yyyy, 'at' h:mm a.");
        return appointmentDate.format(formatter);
    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(LocalDate.now().getYear(), 9, 15);
    }
}
