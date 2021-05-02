package business.persistence;

import business.exceptions.UserException;

public class BuyMapper {
    private Database database;

    public BuyMapper(Database database) {
        this.database = database;
    }

    public void insertBuyEntry() throws UserException{
        //TODO: INSERT DATA INTO DATABASE

    }
}
