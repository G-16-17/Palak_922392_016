<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link type="text/css" rel="stylesheet" href="./style/style.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
    <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <title>Menu Item List Customer</title>
</head>

<body>
    <!-- Uses a header that scrolls with the text, rather than staying
  locked at the top -->
    <input type="hidden" id="page" value="customer">
    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
        <header class="mdl-layout__header">
            <div class="mdl-layout__header-row">
                <!-- Title -->
                <span class="mdl-layout-title">truYum</span>
                <!-- Icon -->
                <img class="mdl-layout-icon logo" src="images/truyum-logo-light.png"></img>
                <!-- Add spacer, to align navigation to the right -->
                <div class="mdl-layout-spacer"></div>
                <!-- Navigation -->
                <nav class="mdl-navigation">
                    <a class="mdl-navigation__link" href="">Menu</a>
                    <a class="mdl-navigation__link" href="">Cart</a>
                </nav>
            </div>
        </header>
        <div class="mdl-layout__drawer">
            <span class="mdl-layout-title">Select Role</span>
            <nav class="mdl-navigation">
                <a class="mdl-navigation__link" href="menu-item-list-admin.html">Admin</a>
                <a class="mdl-navigation__link" href="menu-item-list-customer.html">Customer</a>
            </nav>
        </div>
        <main class="mdl-layout__content">
            <div class="page-content">
                <!-- Your content goes here -->
                <div class="mdl-grid">
                    <div class="mdl-cell mdl-cell--3-col"></div>
                    <div class="mdl-cell--6-col">
                        <table class="mdl-data-table mdl-js-data-table">
                            <caption>
                                <h3>Menu Items</h3>
                            </caption>
                            <br><br>
                            <thead>
                                <tr>
                                    <th style="text-align: left">Name</th>
                                    <th style="text-align: center">Free Delivery</th>
                                    <th style="text-align: right">Price</th>
                                    <th style="text-align: center">Category</th>
                                    <th style="text-align: center">Action</th>
                                </tr>
                            </thead>
                            <tbody id="customer-table">
                                <c:forEach items="${menuItemList}" var="menuItem">
                                <tr>
                                <td>${menuItem.name}</td>
                                 <td>${menuItem.freeDelivery}</td>
                                <td>${menuItem.price}</td>
                                 <td>${menuItem.category}</td>
                                <td>${menuItem.active}</td>                               
                               
                                <td><a href="">Add to Cart</a></td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="mdl-cell mdl-cell--3-col"></div>
                </div>
            </div>
        </main>
        <footer class="mdl-mini-footer">
            <div class="mdl-mini-footer__left-section">
                <div class="mdl-logo">Copyright &copy; 2019</div>
            </div>
        </footer>
    </div>
    <script src="./js/script.js"></script>
</body>