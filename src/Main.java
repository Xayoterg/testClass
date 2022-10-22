
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws ParseException {
        while (true) {
            System.out.println("вылет до текущего момента времени Нажмите  1");
            System.out.println("имеются сегменты с датой прилёта раньше даты вылета Нажмите 2");
            System.out.println("общее время, проведённое на земле превышает два часа Нажмите 3");
            System.out.println("чтобы остановить программу Нажмите 0");
            Scanner scanner = new Scanner(System.in);
            String arrival1 = scanner.nextLine();
            System.out.println("-------------------------------");
            List<Flight> flights = FlightBuilder.createFlights();
            HashSet<Flight> correctFlight = new HashSet<>(); // Результирующая коллекция
            LocalDateTime localDateTime = LocalDateTime.now();
            for (Flight flight : flights) { // Перебираем полёты
                String flightSting = flight.toString();
                String[] segments = flightSting.split(" ");
                for (int i = 0; i < segments.length; i++) {
                    String str = segments[i];
                    StringBuffer sb = new StringBuffer(str);
                    // Чистим от мусора даты вылета и прилёта от скобочек
                    String[] dates = sb.delete(sb.length() - 1, sb.length()).delete(0, 1).toString().split("\\|");
                    LocalDateTime departure = LocalDateTime.parse(dates[0]); // Дата вылета
                    LocalDateTime arrival = LocalDateTime.parse(dates[1]); // Дата прилёта
                    if (arrival1.equals("1")) {
                        if (departure.compareTo(localDateTime) < 0) { // показываем правильные варианты
                            continue;  // Прерывание текущей иттерации цикла
                        } else if (arrival.equals("2")) {
                        }
                        if (arrival.compareTo(departure) < 0) {  // показываем неправильный вариант
                            continue; // Прерывание текущей иттерации цикла

                        }

                    }
                    if (segments.length > 1) {
                        // Думаем как сравнить дату прилёта с датой вылета следующего сегмента
                    } else if (arrival.equals("3")) {
//                        int c1 = departure.compareTo(localDateTime);
//                        int c2 = arrival.compareTo(localDateTime);
//
//                        if ((c1 >= 2 && c2 <= 2) || (c1 <= 2 && c2 >= 2)) {
//                            continue;
//                        }
                    }else if (arrival1.equals("0")) {
                        return;
                    }

                    correctFlight.add(flight);
                }

            }
            System.out.println(correctFlight);

            /*System.out.println(date);*/
            //System.out.println(flights);
        }


    }
}