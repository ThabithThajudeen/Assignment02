//package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.PseudoColumnUsage;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Map<Integer, Passenger> passenger = new HashMap<>();
        Map<Integer, Bus> buses = new HashMap<>();
        Map<Integer, Train> trains = new HashMap<>();
        Map<Integer, Event> events = new HashMap<>();
        int busArrivalCount =0;
        int trainArrivalCount =0;
        int passengerCount =0;
        try {
            Scanner scanner = new Scanner(new File("Passenger.csv"));
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                int accountNumber = Integer.parseInt(data[0]);
                String name = data[1];
                String accountStanding = data[2];
                boolean onboard = Boolean.parseBoolean(data[3]);
                String dateTimeString = data[4]; // Your date-time string
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime timeOfEntry = LocalDateTime.parse(dateTimeString, formatter);
                String timeLeftString = data[5]; // assuming this is where the timeOfLeft is in your data array
                DateTimeFormatter formatter02 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime timeOfLeft = LocalDateTime.parse(timeLeftString, formatter02);
                int busId = Integer.parseInt(data[6]);
                int trainId = Integer.parseInt(data[7]);


                //  Account account = new Account(id, name, accountStanding, isActive, timeOfEntry, timeLeft);
                Passenger passengers = new Passenger(accountNumber, name, accountStanding, onboard, timeOfEntry, timeOfLeft, busId, trainId);

                passenger.put(accountNumber, passengers);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        try {
            Scanner scanner = new Scanner(new File("buses.csv"));
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                int id = Integer.parseInt(data[0]);
                boolean onTime = Boolean.parseBoolean(data[1]);
                double latitude = Double.parseDouble(data[2]);
                double longitude = Double.parseDouble(data[3]);


                Bus bus = new Bus(id, onTime, latitude, longitude);
                buses.put(id, bus);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Scanner scanner = new Scanner(new File("events.csv"));
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                //int id = Integer.parseInt(data[0]);
                //String eventType = data[1];
                //int entityId = Integer.parseInt(data[2]);
                //String eventTime = data[3];

                int eventId = Integer.parseInt(data[1]);
                String eventType = data[2];
                String entityId = data[3];
                String eventTime = data[4];

                if (eventType.equals("Bus has Arrived")){
                    busArrivalCount++;
                } else if (eventType.equals("Train has arrived")) {
                    trainArrivalCount++;

                } else if (eventType.equals("PassengerBoarded")) {
                    passengerCount++;

                } else if (eventType.equals("PassengerExited")) {
                    passengerCount--;

                }

                Event event = new Event(eventId, eventType, entityId, eventTime);
                events.put(eventId, event);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    try {
        Scanner scanner = new Scanner(new File("trains.csv"));
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split(",");
            //int id = Integer.parseInt(data[0]);
            //String eventType = data[1];
            //int entityId = Integer.parseInt(data[2]);
            //String eventTime = data[3];

           // int eventId = Integer.parseInt(data[1]);
           // String eventType = data[2];
          //  String entityId = data[3];
          //  String eventTime = data[4];

            int trainId = Integer.parseInt(data[0]);
            String status = data[1];
            String location = data[2];

            Train train = new Train(trainId,status,location);
            trains.put(trainId,train);


        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
     //   System.out.println("Total Bus Arrivals" + busArrivalCount); // busArrival count
     //   System.out.println("Total Train Arrivals" + trainArrivalCount); // trainArrival-count
     //   System.out.println("Current Passengers" + passengerCount); // passenger count
        Scanner userInput = new Scanner(System.in);
        while(true){
            System.out.println("Please choose an option");
            System.out.println("1.Display bus arrival count");
            System.out.println("2.Display train arrival count");
            System.out.println("3.Display passenger count");
            System.out.println("4.Check weather passenger is onboard");
            System.out.println("5.Check account status of a Passenger");
            System.out.println("6.Check passenger enter and exit time");
            System.out.println("7.Vehicle status");
            System.out.println("8.Exit");

            String choice = userInput.nextLine();

            switch (choice){
                case "1":
                    System.out.println("Bus arrival count" + busArrivalCount);
                    break;
                case "2":
                    System.out.println("Train arrival count" + trainArrivalCount);
                    break;
                case "3":
                    System.out.println("Passenger count" + passenger.size());
                    break;
                case "4":
                    System.out.println("Enter the ID of the passenger to check:");
                    int passengerId = Integer.parseInt(userInput.nextLine());
                    Passenger p = passenger.get(passengerId);
                    if (p.isOnboard()) {
                        int busId = p.getBusId();
                        int trainId = p.getTrainId();
                        if (busId != -1) {
                            System.out.println("Passenger is onboard bus: " + busId);
                        }
                        if (trainId != -1) {
                            System.out.println("Passenger is onboard train: " + trainId);
                        }
                    } else {
                        System.out.println("Passenger is not currently onboard a bus/train");
                    }
                    break;
                case "5":
                    System.out.println("Enter the ID of the passenger whose account status you want to check:");
                    int id = Integer.parseInt(userInput.nextLine());
                    if (passenger.containsKey(id)) {
                        System.out.println("The account status of passenger with ID " + id + " is " + passenger.get(id).getAccountStanding());
                    } else {
                        System.out.println("No passenger found with ID " + id);
                    }
                    break;

                case "6":
                    System.out.println("Enter the ID of the passenger whose enter/exit times you want to check:");
                    int id02 = Integer.parseInt(userInput.nextLine());
                    if (passenger.containsKey(id02)) {
                        System.out.println("Latest enter time for passenger with ID " + id02 + ": " + passenger.get(id02).getTimeOfEntry());
                        System.out.println("Latest exit time for passenger with ID " + id02 + ": " + passenger.get(id02).getTimeOfLeft());
                    } else {
                        System.out.println("No passenger found with ID " + id02);
                    }
                    break;
                case "7":
                    System.out.println("Enter the ID of the bus/train you want to check:");
                    int id03 = Integer.parseInt(userInput.nextLine());
                    if (buses.containsKey(id03)) {
                        System.out.println("Status of bus with ID " + id03 + ": " + buses.get(id03).getStatus());
                    } else if (trains.containsKey(id)) {
                        System.out.println("Status of train with ID " + id + ": " + trains.get(id).getStatus());
                    } else {
                        System.out.println("No bus or train found with ID " + id);
                    }
                    break;
                case "8":
                    System.out.println("Exiting....");
                    System.exit(0);
                default:
                    System.out.println("Invalid option.Please try again.");
            }



        }

}
}
