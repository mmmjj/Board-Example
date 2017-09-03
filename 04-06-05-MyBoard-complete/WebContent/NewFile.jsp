<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
 <title>JSTL: Formatting/I18N Support -- Number, Currency, and Percent
        Example
 </title>
</head>
<body bgcolor="#FFFFFF">
<h3>Formatting numbers, currencies, and percentages using <tt>en-US</tt>
    locale
</h3>

<fmt:setLocale value="en-US" />

<ul>
 <li> Format "123456789" as number:<br>
  <fmt:formatNumber value="123456789" />

 <li> Format "123456789" as percent:<br>
  <fmt:formatNumber type="percent">123456789</fmt:formatNumber>

 <li> Format "12345.67" as currency:<br>
  <fmt:formatNumber value="12345.67" type="currency" />

 <li> Format "12345.67" as currency, with
      grouping turned off, the maximum number of digits in the integer portion
      limited to 4, and no fraction portion:<br>
  <fmt:formatNumber value="12345.67" type="currency"
                    groupingUsed="false" maxIntegerDigits="4"
                    maxFractionDigits="0" />

 <li> Format "12345.67" as currency:<br>
  <fmt:formatNumber value="12345.67" type="currency" /><br>
      then parse its integer portion only and output the result:<br>
  <fmt:formatNumber value="12345.67" type="currency" var="cur" />
  <fmt:parseNumber value="${cur}" type="currency" integerOnly="true" />
</ul>

</body>
</html>
