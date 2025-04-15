package products;

import addon.IO;

import java.util.Objects;

public class Transaction
{
    private final String itemID;
    private final double price;
    private final int amount;
    public Transaction(String itemID, double price, int amount)
    {
        this.itemID = itemID;
        this.price = price;
        this.amount = amount;
    }
    public String getItemID()
    {
        return  this.itemID;
    }
    public  Double getPrice()
    {
        return  this.price;
    }
    public int getAmount()
    {
        return  this.amount;
    }

    @Override
    public boolean equals(Object objOther) {
        if(this == objOther) {
            return true;
        }
        if(objOther == null || getClass() != objOther.getClass()) {
            return false;
        }
        Transaction that = (Transaction) objOther;
        return this.price == that.price && amount == that.amount && itemID.equals(that.itemID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemID, price, amount);
    }

    public String toString() {
        return String.format(
                "%s: %d item(s). %s SEK",
                this.itemID,
                this.amount,
                IO.truncateToString(this.price, 2)
        );
    }
}
