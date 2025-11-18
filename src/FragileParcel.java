public class FragileParcel extends Parcel implements Trackable{

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка <<"+getDescription()+">> обёрнута в защитную плёнку");
        System.out.println("Посылка <<"+getDescription()+">> упакована");
    }

    @Override
    public int calculateDeliveryCost() {
        return getWeight()*basecostFragile;
    }

    @Override
    public String reportStatus(String newLocation) {
        return "Хрупкая посылка <<" + getDescription() +">> изменила местоположение на " + newLocation;
    }
}
