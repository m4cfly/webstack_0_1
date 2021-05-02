package business.services;

import business.exceptions.UserException;
import business.persistence.BuyMapper;
import business.persistence.Database;

import java.util.List;

public class BuyFacade {

    private BuyMapper buyMapper;

    public BuyFacade(Database database) {
        this.buyMapper = new BuyMapper(database);
    }

    public void insertBuyEntry(
            double result,
            double buyamount,
            double coinprice,
            String category,
            String gender,
            int coin_id,
            List<String> infoList) throws UserException{
        buyMapper.insertBuyEntry(result, buyamount,coinprice,category,gender,coin_id,infoList);
    }
}
