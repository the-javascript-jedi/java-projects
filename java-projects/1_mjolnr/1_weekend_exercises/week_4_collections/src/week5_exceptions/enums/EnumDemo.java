package week5_exceptions.enums;

// Exercise: Create an enum DayOfWeek with 7 days, then in main:
// - Store a day in a variable
// - Print it
// - Use it in a switch statement — print "Weekday" for Mon–Fri, "Weekend" for Sat–Sun
// - Loop through all enum values with DayOfWeek.values() and print each one
public class EnumDemo {
    // Enum with 7 constants, one for each day of the week
    enum DayOfWeek {  MONDAY, TUESDAY, WEDNESDAY, THURSDAY,
        FRIDAY, SATURDAY, SUNDAY }

   public static void main(String[] args){
       // Store a day in a variable and print it
       DayOfWeek day = DayOfWeek.FRIDAY;
       System.out.println("Selected day: " + day);

       // Switch on the enum value to classify it as weekday or weekend
       switch (day) {
           case MONDAY:
           case TUESDAY:
           case WEDNESDAY:
           case THURSDAY:
           case FRIDAY:
               System.out.println("Weekday");
               break;

           case SATURDAY:
           case SUNDAY:
               System.out.println("Weekend");
               break;
       }

       // enhanced for loop: values() returns all constants in declaration order
       System.out.println("All days:");
       for (DayOfWeek currentDay : DayOfWeek.values()) {
           System.out.println("advance loop for "+currentDay);
       }

       DayOfWeek[] days = DayOfWeek.values();
        // normal for loop over the same array, indexed this time
       for (int i = 0; i < days.length; i++) {
           System.out.println("normal loop for "+days[i]);
       }
   }
}
//OP
//Selected day: FRIDAY
//        Weekday
//All days:
//advance for MONDAY
//advance for TUESDAY
//advance for WEDNESDAY
//advance for THURSDAY
//advance for FRIDAY
//advance for SATURDAY
//advance for SUNDAY
//normal for MONDAY
//normal for TUESDAY
//normal for WEDNESDAY
//normal for THURSDAY
//normal for FRIDAY
//normal for SATURDAY
//normal for SUNDAY