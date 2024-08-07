package clientcode;

import data.airport.model.FlightData;
import data.airport.model.FlightDataCollection;
import data.airport.states.Arriving;
import data.airport.states.Boarding;
import totem.airport.Totem;

import java.util.Scanner;

public class Airport {
    private static Scanner scanner = new Scanner(System.in);
    private FlightDataCollection collection = new FlightDataCollection();

    public void run() {
        Totem arrivingTotem = new Totem(0, 0,"Arriving Totem");
        Totem boardingTotem = new Totem(415, 0,"Boarding Totem");
        Totem arriveAndBoardTotem = new Totem(830, 0,"arriveAndBoardTotem");

        arrivingTotem.startTotem(Arriving.getInstance());
        boardingTotem.startTotem(Boarding.getInstance());
        arriveAndBoardTotem.startTotem(Boarding.getInstance(), Arriving.getInstance());

        collection.register(arrivingTotem);
        collection.register(boardingTotem);
        collection.register(arriveAndBoardTotem);

        int option;
        do{
            System.out.println("1 - Novo voo");
            System.out.println("2 - Alterar estado");
            System.out.println("3 - Lista de Voos");
            System.out.println("0 - Encerrar");
            System.out.println("Opção: ");
            option = scanner.nextInt();

            switch (option){
                case 1:
                    collection.insertFlight(readFlight());
                    System.out.println("Voo adicionado.");
                    break;

                case 2:
                    updateFlight();
                    break;

                case 3:
                    for (FlightData fligth : collection.allFlights()){
                        System.out.println(fligth);
                    }
                    break;

                default:
                    System.out.println("Aeroporto fechado!");
                    arrivingTotem.closeFrame();
                    boardingTotem.closeFrame();
                    arriveAndBoardTotem.closeFrame();
                    break;
            }
        }while (option != 0);
    }

    private void updateFlight(){
        Long number;
        System.out.println("Número do voo: ");
        number = scanner.nextLong();
        collection.updateFlight(number);
        System.out.println("Estado do voo editado.");
    }

    private FlightData readFlight(){
        Long number;
        String company;
        String time;

        System.out.println("Número do voo.: ");
        number = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Companhia.....: ");
        company = scanner.nextLine();
        System.out.println("Horário.......: ");
        time = scanner.nextLine();

        return new FlightData(number, company, time);
    }

    public static void main(String[] args) {
        new Airport().run();
    }
}
