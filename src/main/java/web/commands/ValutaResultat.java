package web.commands;

import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValutaResultat extends CommandUnprotectedPage{
    public ValutaResultat(String pageToShow) {
        super(pageToShow);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        double antal = 0.0;
        double prcoin = 0.0;
        double resvaluta = 0.0;
        String category = "";
        String skill = request.getParameter("skill");

        try {
        antal = Double.parseDouble(request.getParameter("antal"));
        prcoin = Double.parseDouble(request.getParameter("prcoin"));

        } catch (NumberFormatException ex){
            throw new UserException("Husk at indtaste to heltal i formularen.");
        }
        resvaluta = antal * prcoin;

        if( resvaluta <= 100){
            category = "Du har under 100 credits";
        }
        else if (resvaluta <= 500){
            category = "Du har under 200 credits";
        }
        else if (resvaluta > 1000) {
            category = "Du har over 1000 credits";
        }
        else if (resvaluta > 2000){
                category = "Du har over 2000 credits";
        }
        else if (resvaluta > 3000){
            category = "Du har over 3000 credits";
        } else {
            category = "Dine credits blev ikke defineret ordentligt.";
        }

        request.setAttribute("resvaluta", resvaluta);
        request.setAttribute("antal", antal);
        request.setAttribute("prcoin", prcoin);
        request.setAttribute("category", category);

        return (pageToShow);
    }
}