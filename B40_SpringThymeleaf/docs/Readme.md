Spring and Thymeleaf
====================

http://itutorial.thymeleaf.org/
https://www.thymeleaf.org/documentation.html

Standard Expression syntax
==========================

Most Thymeleaf attributes allow their values to be set as or containing expressions, which we will
call Standard Expressions because of the dialects they are used in. These can be of five types:

 - ${...} : Variable expressions.
 - *{...} : Selection expressions.
 - #{...} : Message (i18n) expressions.
 - @{...} : Link (URL) expressions.
 - ~{...} : Fragment expressions.


Variable expressions
--------------------

Variable expressions are OGNL expressions (or Spring EL if you’re integrating Thymeleaf with Spring)
executed on the context variables (also called model attributes in Spring jargon). They look like:

  ${book.author.name}

  the expression above is equivalent to: ((Book)context.getVariable("book")).getAuthor().getName()


Selection expressions
---------------------

Selection expressions are just like variable expressions, except they will be executed on a
previously selected object instead of the whole context variables map. The object they act on is
specified by a th:object attribute. They look like:

  <div th:object="${book}">
    ...
    <span th:text="*{title}">...</span>
    ...
  </div>


Message (i18n) expressions
--------------------------

Message expressions (often called text externalization, internationalization or i18n) allows us to
retrieve locale-specific messages from external sources (.properties files), referencing them by a
key and (optionally) applying a set of parameters.
In Spring applications, this will automatically integrate with Spring’s MessageSource mechanism.

  #{main.title}
  #{message.entrycreated(${entryId})}

  <table>
    ...
    <th th:text="#{header.address.city}">...</th>
    <th th:text="#{header.address.country}">...</th>
    ...
  </table>

You can use variable expressions inside message expressions if you want the message key to be
determined by the value of a context variable, or you want to specify variables as parameters:

  #{${config.adminWelcomeKey}(${session.user.name})}


Link (URL) expressions
----------------------

Link expressions are meant to build URLs and add useful context and session info to them (a process
usually called URL rewriting). So for a web application deployed at the /myapp context of your web
server, an expression such as:

  <a th:href="@{/order/list}">...</a>
  Could be converted into something like this:
  <a href="/myapp/order/list">...</a>

Or even this, if we need to keep sessions and cookies are not enabled (or the server doesn’t know
yet):

  <a href="/myapp/order/list;jsessionid=23fa31abd41ea093">...</a>

URLs can also take parameters:

  <a th:href="@{/order/details(id=${orderId},type=${orderType})}">...</a>
  Resulting in something like this:
  <!-- Note ampersands (&) should be HTML-escaped in tag attributes... -->
  <a href="/myapp/order/details?id=23&amp;type=online">...</a>

Link expressions can be relative, in which case no application context will be prefixed to the URL:

  <a th:href="@{../documents/report}">...</a>

Also server-relative (again, no application context to be prefixed):

  <a th:href="@{~/contents/main}">...</a>

And protocol-relative (just like absolute URLs, but browser will use the same HTTP or HTTPS
protocol used in the page being displayed):

  <a th:href="@{//static.mycompany.com/res/initial}">...</a>

And of course, Link expressions can be absolute:

  <a th:href="@{http://www.mycompany.com/main}">...</a>


Fragment expressions
--------------------

Fragment expressions are an easy way to represent fragments of markup and move them around
templates. Thanks to these expressions, fragments can be replicated, passed to other templates as
arguments, and so on. The most common use is for fragment insertion using th:insert or th:replace:

  <div th:insert="~{commons :: main}">...</div>

But they can be used anywhere, just as any other variable:

  <div th:with="frag=~{footer :: #main/text()}">
    <p th:insert="${frag}">
  </div>


Some basic attributes
=====================

 - th:text
   replaces the body of a tag (notice again the prototyping abilities here):
   <p th:text="#{msg.welcome}">Welcome everyone!</p>
 - th:each
   repeats the element it’s in as many times as specified by the array or list returned by its
   expression, creating also an inner variable for the iteration element with a syntax equivalent
   to that of a Java foreach expression:
   <li th:each="book : ${books}" th:text="${book.title}">En las Orillas del Sar</li>
 - th:action
   Thymeleaf includes lots of th attributes for specific XHTML and HTML5 attributes which just
   evaluate their expressions and set the value of these attributes to their result. Their names
   mimic those of the attributes which values they set:
   <form th:action="@{/createOrder}">
   <input type="button" th:value="#{form.submit}" />
   <a th:href="@{/admin/users}">






