public class PerishableParcel extends Parcel{

    private static final int basecostPerish = 4;
    private int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public int calculateDeliveryCost() {
        return getWeight()*basecostPerish;
    }

    public boolean isExpired(int currentDay){
        return (getSendDay()+timeToLive) >= currentDay;
    }
}
