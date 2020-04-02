import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class JavaExamDateTime {
    public static void main(String args[]){
        // static methods
        System.out.println(LocalDate.now()); // 2020-03-27
        System.out.println(LocalTime.now()); // 18:58:12.740 : hours, minutes, seconds, and nanoseconds.
        System.out.println(LocalDateTime.now()); // 2020-03-27T18:58:12.740 : T to seperate

        String dateTimeNowString1 = LocalDate.now() + "T" + LocalTime.now();
        String dateTimeNowString2 = LocalDateTime.now().toString();
        System.out.println(dateTimeNowString1 + " compared to " + dateTimeNowString2 + " : " + (dateTimeNowString1.equals(dateTimeNowString2))); // recall that String.equals(String) check for char by char
        
    }

    static class CreatingLocalDate {
        public static void main(String args[]){
            LocalDate localDate1 = LocalDate.of(2020, Month.MARCH, 27);
            LocalDate localDate2 = LocalDate.of(2020, 3, 27);
            System.out.println(localDate1.toString().equals(localDate2.toString())); // String : 2020-03-07
        }
    }

    static class CreatingLocalTime {
        public static void main(String args[]){
            LocalTime localTime2 = LocalTime.of(10, 2);
            LocalTime localTime3 = LocalTime.of(10, 2, 59);
            LocalTime localTime4 = LocalTime.of(10, 2, 59, 999999999);

            System.out.println(localTime4);
        }
    }

    static class CreatingLocalDateTime {
        public static void main(String args[]){
            LocalDate localDate = LocalDate.of(2020, Month.MARCH, 27);
            LocalTime localTime = LocalTime.of(10, 2, 59, 999999999);
            LocalDateTime localDateTime1 = LocalDateTime.of(localDate, localTime);
            System.out.println(localDateTime1);

            LocalDateTime localDateTime2 = LocalDateTime.of(2020, 3, 27, 10, 2, 59);
            System.out.println(localDateTime2);
        }
    }

    static class ManipulatingDateTime {
        public static void main(String args[]){
            LocalDate localDate = LocalDate.of(2020, Month.MARCH, 27);
            LocalTime localTime = LocalTime.of(10, 2);

            System.out.println(localDate.plusDays(3));
            System.out.println(localDate.minusDays(3));
            System.out.println(localDate.plusMonths(3)); // plusWeeks , plusYears
            System.out.println(localDate.minusMonths(3));

            // System.out.println(localDate.minusMinutes(3)); // DOES NOT COMPILE

            System.out.println(localTime.minusHours(11)); // 10hr - 11hours -> 23hr
            System.out.println(localTime.plusHours(14)); // 10hr + 14hours -> 00hr
    
        }
    }

    static class ManipulatingDateUsingPeriods {
        public static void main(String args[]){
            LocalDate localDate = LocalDate.of(2020, Month.MARCH, 27);
            LocalTime localTime = LocalTime.of(10, 2);  
            LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

            Period day = Period.ofDays(1);
            Period week = Period.ofWeeks(1);
            Period month = Period.ofMonths(1);
            Period year = Period.ofYears(1);
            LocalDate afterPlus = localDate.plus(day).plus(week).plus(month).plus(year); 
            System.out.println(afterPlus);

            Period yearMonthDay = Period.of(1, 1, 1); // note that it has no week option
            LocalDate afterPlusMinusWeek =  localDate.plus(yearMonthDay);
            System.out.println(afterPlusMinusWeek);

            // NO PERIOD FOR TIME
        }
    }

    static class FormattingDateTime {
        public static void main(String args[]){
            LocalDate localDate = LocalDate.of(2020, Month.MARCH, 27);
            LocalTime localTime = LocalTime.of(10, 2, 11);  
            LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

            System.out.println("BASIC_ISO_DATE: " + localDateTime.format(DateTimeFormatter.BASIC_ISO_DATE));            // 20200327
            System.out.println("ISO_LOCAL_DATE: " + localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE));            // 2020-03-27
            System.out.println("ISO_DATE_TIME: " + localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));              // 2020-03-27T10:02:11
            System.out.println("ISO_LOCAL_DATE_TIME: " + localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));  // 2020-03-27T10:02:11
            System.out.println("ISO_LOCAL_TIME: " + localDateTime.format(DateTimeFormatter.ISO_LOCAL_TIME));            // 10:02:11
            System.out.println("ISO_TIME: " + localDateTime.format(DateTimeFormatter.ISO_TIME));                        // 10:02:11

            DateTimeFormatter f = DateTimeFormatter.ofLocalizedTime(FormatStyle
            .SHORT);
            System.out.println(localDateTime.format(f));

        }
    }
}