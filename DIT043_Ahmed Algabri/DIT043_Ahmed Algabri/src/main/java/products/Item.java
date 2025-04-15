package products;

import java.util.*;
import addon.IO;

import static java.util.Objects.hash;

public class Item
{
    //private date
    private final String id;
    private  String name;
    private double price;
    public ArrayList<Review> reviews;
    private static  final String EOL = System.lineSeparator();

    public  Item(String id, String name, double price)
    {
        this.id = id;
        this.name = name;
        this.price = IO.truncate(price,2);
        reviews = new ArrayList<>();
    }

    public  String getID()
    {
        return  this.id;
    }
    public  String getName()
    {
        return  this.name;
    }
    public double getPrice()
    {
        return  this.price;
    }
    public String getOneReview(int index)
    {
        String result="";
        if(index>0 && index<=this.reviews.size())
        {
            result = this.reviews.get(index-1).toString();
        }
        else
        {
            result = "Invalid review number. Choose between 1 and "+ this.reviews.size()+".";
        }
        return  result;
    }
    public  String getAllReviews()
    {
        String result = "";
        for(Review rev : this.reviews)
        {
            result += rev + EOL;
        }
        return  result;
    }
    public  void setName(String name)
    {
        this.name = name;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }

    public double buy(int amount) {
        final int discount = 4;
        double totalPrice;
        if(amount<discount)
        {
            totalPrice= this.price * amount;
        }
        else
        {
            totalPrice = this.price * (discount+(amount-discount)*0.7);
        }
        totalPrice = IO.truncate(totalPrice,2);
        return  totalPrice;

    }

   public  void addReview(int grade, String comment)
    {
        Review review = new Review(grade,comment);
        this.reviews.add(review);
    }


    public  boolean isID(String id)
    {
        return  this.id.equals(id);
    }
    public boolean isName(String name)
    {
        return  this.name.equals(name);
    }
    public  boolean equals(Object obj)
    {
        if(this==obj)
        {
            return  true;
        }
        else if(obj==null)
        {
            return  false;
        }
        else if(getClass()==obj.getClass())
        {
            return  this.id.equals(( (Item) obj).id);
        }
        return  false;
    }

    public  int hashCode()
    {
        return  hash(this.id);
    }




    public String toString() {
        return String.format("%s: %s. %s SEK", this.id, this.name, IO.truncateToString(this.price, 2));
    }

    public  double calcMeanGrade()
    {
        int tot=0;
        for(Review review : this.reviews)
        {
            tot+=review.getGrade();
        }
        double mean = IO.truncate((double) tot / reviews.size(), 1);
        return mean;
    }
    public boolean hasReview()
    {
        if(!this.reviews.isEmpty())
        {
            return  true;
        }
        else
        {
            return  false;
        }
    }
    public ArrayList<String> getItemComments()
    {
        ArrayList<String> itemComments = new ArrayList<>();
        for(Review review : this.reviews )
        {
            if(!review.getComment().isEmpty())
            {
                itemComments.add(review.getComment());
            }
        }
        return  itemComments;
    }
    public int reviewSize()
    {
        return  this.reviews.size();
    }

}
