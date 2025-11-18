public abstract class Parcel {
    private String description;
    private int weight;
    private String deliveryAddress;
    private int sendDay;

    public static final int basecostStandart = 2;
    public static final int basecostFragile = 3;
    public static final int basecostPerish = 4;


    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public int getSendDay() {
        return sendDay;
    }

    public void packageItem(){
        System.out.println("Посылка <<"+description+">> упакована");
    }


    public void deliver(){
        System.out.println("Посылка <<"+description+">> доставлена по адресу" + deliveryAddress);
    }

    public abstract int calculateDeliveryCost();
}

