import java.util.ArrayList;

public class ParcelBox <T extends Parcel>{

    private int maxweight;
    private ArrayList<T> parcelsBox = new ArrayList<>();

    public ParcelBox(int maxweight) {
        this.maxweight = maxweight;
    }

    public ArrayList<T> getAllParcels() {
        return parcelsBox;
    }

    public void addParcel(T parsel){
        int totalWeight = 0;
        for(T parsbox : parcelsBox){
            totalWeight += parsbox.getWeight();
        }
        if(totalWeight + parsel.getWeight()<maxweight){
            parcelsBox.add(parsel);
        }else {
            System.out.println("Вес посылки превышает вес коробки!");
        }
    }
}
