<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Crypto køb Resultat:
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${true}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <h2>Du har lagt crypto i din kurv:</h2>
            <p>
                Dit krypto antal er: <b> ${requestScope.buyamount}</b>
                pris pr mønt: <b>${requestScope.coinprice}</b>
            </p>
            <p>
                Din valuta beregning er: <b> ${requestScope.result} </b>
            </p>
            <p>${requestScope.category}</p>

            <p> Køn: ${requestScope.gender}</p>
            <br>
            <p> Coin ID: ${requestScope.coin_id}</p>

            <c:forEach var="infoItem" items="${requestScope.infos}">
                info: ${infoItem} <br/>
            </c:forEach>





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
        </div>
    </jsp:body>
</t:genericpage>