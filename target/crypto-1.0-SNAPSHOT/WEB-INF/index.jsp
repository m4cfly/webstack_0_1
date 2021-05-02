<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Forside
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${true}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div class="row">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <h2>Køb Crypto</h2>

                <form method="post" action="fc/buyfinalresult">

                    <div class="form-group">
                        <input type="radio" id="male" name="gender" value="male">
                        <label for="male">Male</label><br>
                        <input type="radio" id="female" name="gender" value="female">
                        <label for="female">Female</label><br>
                        <input type="radio" id="other" name="gender" value="other">
                        <label for="other">Other</label>
                    </div>
                    <div class="form-group">
                        <select name="coin_id" class="form-select" aria-label="Default select example">
                            <option selected>Select Coin</option>
                            <option value="1">BTC</option>
                            <option value="2">ETH</option>
                            <option value="3">ADA</option>
                            <option value="3">DOT</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="checkbox" id="vehicle1" name="info" value="Bike">
                        <label for="vehicle1"> I have a bike</label><br>
                        <input type="checkbox" id="vehicle2" name="info" value="Car">
                        <label for="vehicle2"> I have a car</label><br>
                        <input type="checkbox" id="vehicle3" name="info" value="Boat">
                        <label for="vehicle3"> I have a boat</label><br>
                    </div>
                    <div class="form-group">
                        <label for="buyamount">køb BOING COIN $:</label>
                        <input id="buyamount" name="buyamount" type="text" class="form-control"/>
                    </div>
                    <br>
                    <div class="form-group">
                        <label for="coinprice">0.30$</label>
                        <input id="coinprice" name="coinprice" type="text" placeholder="0.30" value="0.30" class="form-control"/>
                    </div>

                    <br><br>

                    <button class="btn btn-success" type="submit">Buy Crypto</button>

                </form>

                <br>

            <h2>Crypto Beregner</h2>

            <form method="post" action="fc/valresult">
                <div class="form-group">
                    <label for="antal">Antal krypto:</label>
                    <input id="antal" name="antal" type="text" class="form-control"/>
                </div>
                <br>
                <div class="form-group">
                    <label for="prcoin">Krypto værdi pr mønt:</label>
                    <input id="prcoin" name="prcoin" type="text" class="form-control"/>
                </div>

                <br><br>

                <button class="btn btn-success" type="submit">Crypto Beregner</button>

            </form>
                <br><br>

            <p> Her er et link til resultatsiden af din convertering:
                <a href="fc/valresult">Resultatside</a></p>
            </p>

            <c:if test="${sessionScope.role == 'employee' }">
                <p style="font-size: larger">This is what you can do,
                    since your are logged in as an employee</p>
                <p><a href="fc/employeepage">Employee Page</a></p>
             </c:if>

             <c:if test="${sessionScope.role == 'customer' }">
                <p style="font-size: larger">This is what you can do, since your
                    are logged in as a customer</p>
                <p><a href="fc/customerpage">Customer Page</a></p>
            </c:if>
            </div>
            <div class="col-sm-4"></div>
        </div>

    </jsp:body>
</t:genericpage>