package web.commands;

import business.exceptions.UserException;
import business.services.BuyFacade;
import business.services.BuyUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

public class BuyResultat extends CommandUnprotectedPage{

    //private class BuyFacade buyFacade;
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
            request.setAttribute("error", "Husk at indtaste to heltal i formularen. ");
            return "index";
            //throw new UserException("Husk at indtaste to heltal i formularen.");
        }
        result = BuyUtil.calcBuy(buyamount,coinprice);

        category = BuyUtil.getCategory(result);

        request.setAttribute("result", String.format("%.2f", result));
        request.setAttribute("buyamount", buyamount);
        request.setAttribute("coinprice", coinprice);
        request.setAttribute("category", category);
        request.setAttribute("gender", gender);
        request.setAttribute("coin_id", coin_id);
        request.setAttribute("info", infoList);

        //BuyFacade.insertBuyEntry(result, buyamount,coinprice,category,gender,coin_id,infoList);

        return (pageToShow);
    }
}