<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file = "header.jsp"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="productTag" uri="/tld/ProductViewTag.tld"%>
<%@ taglib prefix="paginationTag" uri="/tld/PaginationTag.tld"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <link href="../styles/homePage.css" rel="stylesheet">
    <link href="../styles/products.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Products</title>
</head>

<body>
    <form id="amountOfProductsForm" method="GET" action="/products">
        <div id="filter-settings">
        Amount of products on page: <input name="amountOfProductsFromForm" id="amountOfProductsOnPage" type="number" value="${amountOfProducts}"/>
        <input type="submit" value="ok"/>
        </div>
    </form>
        <select form="amountOfProductsForm" name="sort" onchange="this.form.submit()">
            <c:set var="sortType" value="${filters.currentSort}"/>
            <c:if test="${not empty sortType}">
              <option value="${sortType}">${sortType}</option>
            </c:if>
           <option value="byPriceFromLow">Price from low to high</option>
           <option value="byPriceFromHigh">Price from high to low</option>
           <option value="byAlphabeticalFromA-Z">A-Z</option>
           <option value="byAlphabeticalFromZ-A">Z-A</option>
        </select>
    <div id="common">
        <div id="left-column">

          <!-- filters-->
              <div id="filter-manufacture">
                  Manufacture<br>
                  <c:set var="manufactures" value="${filters.manufactures}"/>
                  <c:set var="manufactureCheck" value="${filters.choosenManufactureList}"/>
                  <productTag:ViewListOfFilters list="${manufactures}" checkedList="${manufactureCheck}" parameterName="manufacture"/>
                  <br>
              </div>
              <div id="price-filter">
                  Price<br>
                  Min: <input form="amountOfProductsForm" id="minPrice" type="number" name="minPrice" value="${filters.minPrice}"><br>Max: <input id="maxPrice" type="number" name="maxPrice" value="${filters.maxPrice}"><br><br>
              </div>
              <div id="category-filter">
                  Category<br>
                  <productTag:ViewListOfFilters list="${filters.categories}" checkedList="${filters.chossenCategoryList}" parameterName="category"/>
              </div>
              <br>
              <input form="amountOfProductsForm" type="submit" value=ok><br>
        </div>
        <div id="center-column">
           <paginationTag:PaginationTag/>
        </div>

    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script defer src="..\javascript\constants\constants.js"></script>
    <script defer src="..\javascript\validators\AmountOfProductsValidator.js"></script>
</body>

</html>