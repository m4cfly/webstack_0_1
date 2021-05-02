package business.persistence;

import business.exceptions.UserException;

import java.util.List;

public class BuyMapper {
    private Database database;

    public BuyMapper(Database database) {
        this.database = database;
    }

    public void insertBuyEntry(
            double result,
            double buyamount,
            double coinprice,
            String category,
            String gender,
            int coin_id,
            List<String> infoList) throws UserException{
        //TODO: INSERT DATA INTO DATABASE

    }
}
