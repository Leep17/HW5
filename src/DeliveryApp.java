import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<FragileParcel> fragileParcels = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    System.out.println("Введите имя посылки:");
                    String description = scanner.nextLine();
                    for(int i = 0; i<fragileParcels.size(); i++){
                        if(fragileParcels.get(i).getDescription().equals(description)){
                            System.out.println("Введите новое местоположение:");
                            String newLocation = scanner.nextLine();
                            System.out.println(fragileParcels.get(i).reportStatus(newLocation));
                            return;
                        }
                    }
                    System.out.println("Таких пасылок нет!");
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Отобразить информацию о новом местоположении");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels

            System.out.println("Выберите тип посылки :");
            System.out.println("1 — Стандартная посылка");
            System.out.println("2 — Хрупкая посылка");
            System.out.println("3 — Скоропортящаяся посылка");

            int typeChoice = Integer.parseInt(scanner.nextLine());

            if (typeChoice != 1 && typeChoice != 2 && typeChoice != 3){
                System.out.println("Введен неверный тип посылки!");
                return;
            }

            System.out.println("Введите описание посылки:");
            String description = scanner.nextLine();

            System.out.println("Введите вес посылки:");
            int weight = Integer.parseInt(scanner.nextLine());

            System.out.println("Введите адрес доставки посылки:");
            String deliveryAddress = scanner.nextLine();

            System.out.println("Введите день отправки посылки:");
            int sendDay = Integer.parseInt(scanner.nextLine());

            switch (typeChoice) {
                case 1:
                    Parcel parcelSt = new StandardParcel(description, weight, deliveryAddress, sendDay);
                    allParcels.add(parcelSt);
                    break;
                case 2:
                    FragileParcel parcelFr = new FragileParcel(description, weight, deliveryAddress, sendDay);
                    allParcels.add(parcelFr);
                    fragileParcels.add(parcelFr);
                    break;
                case 3:
                    System.out.println("Введите срок хранения посылки:");
                    int timeToLive = Integer.parseInt(scanner.nextLine());
                    Parcel parcelPer = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                    allParcels.add(parcelPer);
                    break;
                default:
                    break;
            }
    }


    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels){
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        int totalCost = 0;
        for (Parcel parcel : allParcels){
            totalCost += parcel.calculateDeliveryCost();
        }
        System.out.println(totalCost);
    }

}
