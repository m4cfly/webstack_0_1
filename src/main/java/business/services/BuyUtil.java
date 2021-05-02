package business.services;

public class BuyUtil {
    public static Double calcBuy(Double buyamount,Double coinprice)
    {
        return buyamount * coinprice;
    }

    public static String getCategory(Double result) {

        String category ="";
        if( result <= 100){
            category = "Du har under 100 credits";
        }
        else if (result < 500){
            category = "Du har under 200 credits";
        }
        else if (result < 1000) {
            category = "Du har over 1000 credits";
        }
        else if (result < 2000){
            category = "Du har over 2000 credits";
        }
        else if (result < 3000){
            category = "Du har over 3000 credits";
        } else {
            category = "Dine credits blev ikke defineret ordentligt.";
        }
        return category;
    }

}
