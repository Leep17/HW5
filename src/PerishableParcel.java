public class PerishableParcel extends Parcel{

    private int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public int calculateDeliveryCost() {
        return getWeight()*basecostPerish;
    }

    private boolean isExpired(int currentDay){
        if (getSendDay()+timeToLive>=currentDay){
            return false;
        }else{
            return true;
        }
    }
}
