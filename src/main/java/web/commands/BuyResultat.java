package web.commands;

import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

public class BuyResultat extends CommandUnprotectedPage{
    public BuyResultat(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        double buyamount = 0.0;
        double coinprice = 0.0;
        double result = 0.0;
        String category = "";
        String gender = request.getParameter("gender");
        int coin_id = Integer.parseInt(request.getParameter("coins"));

        String [] infos = request.getParameterValues("info");
        List<String> infoList = null;
        if(infos != null){
            infoList = Arrays.asList(infos);
        }


        try {
        buyamount = Double.parseDouble(request.getParameter("buyamount"));
        coinprice = Double.parseDouble(request.getParameter("coinprice"));

        } catch (NumberFormatException ex){
            throw new UserException("Husk at indtaste to heltal i formularen.");
        }
        result = buyamount * coinprice;


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

        request.setAttribute("result", result);
        request.setAttribute("buyamount", buyamount);
        request.setAttribute("coinprice", coinprice);
        request.setAttribute("category", category);
        request.setAttribute("gender", gender);
        request.setAttribute("coin_id", coin_id);
        request.setAttribute("info", infoList);

        return (pageToShow);
    }
}