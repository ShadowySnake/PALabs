package bonusPackage.interfaces;

/**
 * author: Zamfir Adrian-Iulian
 * An interface used for all locations that can be Payable.
 */
public interface Payable {

    default void setDefaultPrice(){
        this.setEntryPrice(10.00);
    }
    void setEntryPrice(double givenPrice);

    double getEntryPrice();
}
