import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class DeliveryParcelTest {

    @Test
    public void testTypeParcelCost() {
        int expectedCost1 = 4;
        int expectedCost2 = 12;
        int expectedCost3 = 12;

        StandardParcel standardParcel = new StandardParcel("Стандартная", 2, "Грина д5", 1);
        Assertions.assertEquals(expectedCost1, standardParcel.calculateDeliveryCost());

        FragileParcel fragileParcel = new FragileParcel("Хрупкая", 4, "Гарелова д15", 2);
        Assertions.assertEquals(expectedCost2, fragileParcel.calculateDeliveryCost());

        PerishableParcel perishableParcel = new PerishableParcel("Скоропортящаяся", 3, "Мясницкая д13", 3, 7);
        Assertions.assertEquals(expectedCost3, perishableParcel.calculateDeliveryCost());
    }
    @Test
    public void testIsExpired() {

        PerishableParcel expiredParcel = new PerishableParcel("Скоропортящаяся1", 2, "Ленина д1", 3, 2);
        Assertions.assertTrue(expiredParcel.isExpired(7));

        PerishableParcel notExpiredParcel = new PerishableParcel("Скоропортящаяся2", 2, "Гагарина д2", 4, 7);
        Assertions.assertFalse(notExpiredParcel.isExpired(4));
    }

    @Test
    public void testMaxWeight() {

        ParcelBox<StandardParcel> box = new ParcelBox<>(10);

        StandardParcel parcel1 = new StandardParcel("Стандартная1", 5, "Ревалюции1", 2);
        Assertions.assertNull(box.addParcel(parcel1));

        StandardParcel parcel2 = new StandardParcel("Стан", 7, "Адрес", 1);
        Assertions.assertNotNull(box.addParcel(parcel2));
    }

}
