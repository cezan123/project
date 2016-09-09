import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.OptionalLong;
import java.util.StringJoiner;

/**
 * Created by cezan on 05-Sep-16.
 */
public class Opslag {
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private String date = "";
    private int bookNmr = 0;
    private String category = "";
    private double price = 0;


    public String getDate() {
        return date;
    }

    public int getBookNmr() {
        return bookNmr;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }


    public Opslag(int bookNmr, String category, double price)
    {
        Date date1 = new Date();
        date = dateFormat.format(date1);
        this.bookNmr = bookNmr;
        this.category = category;
        this.price = price;
    }
}
