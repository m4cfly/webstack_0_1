package business.services;

import business.exceptions.UserException;
import business.persistence.BuyMapper;
import business.persistence.Database;

public class BuyFacade {
    private BuyMapper buyMapper;

    public BuyFacade(Database database) {
        this.buyMapper = new BuyMapper(database);
    }

    public void insertBuyEntry() throws UserException{
        buyMapper.insertBuyEntry();
    }
}
