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


Formatting dates
================

 - https://www.thymeleaf.org/doc/tutorials/2.1/usingthymeleaf.html#appendix-b-expression-utility-objects


Literal Substitutions
=====================

Concatenation:
  th:text="'The name of the user is ' + ${user.name}"

Preprocessing:
  __${expression}__
  The preprocessing String __ can be escaped in attributes using \_\_.

  article.text=@myapp.translator.Translator@translateToFrench({0})
  <p th:text="${__#{article.text('textVar')}__}">Some text here...</p>

  result: <p th:text="${@myapp.translator.Translator@translateToFrench(textVar)}">Some text here...</p>

Literal substitutions:
  Literal substitutions allow the easy formatting of strings containing values from variables
  without the need to append literals with '...' + '...'. These substitutions must be surrounded by
  vertical bars (|).

  <span th:text="|Welcome to our application, ${user.name}!|">

  result: <span th:text="'Welcome to our application, ' + ${user.name} + '!'">

  Literal substitutions can be combined with other types of expressions. Note: only variable
  expressions (${...}) are allowed inside |...| literal substitutions. No other literals ('...'),
  boolean/numeric tokens, conditional expressions etc. 

  <span th:text="${onevar} + ' ' + |${twovar}, ${threevar}|">


Comments
========

HTML comment (visible in page source):
  <!-- [1] Start of the HTML main content -->

Thymeleaf comment (not visible in page source):
  <!--/* [2] The bean product is set in the controller */-->

Generated-only content:
  This content is not visible when the template is open statically but visible when the template
  is open dynamically.

  <!--/*/
  <dt>[3] Product price</dt>
  <dd th:text="${product.price}">350</dd>
  /*/-->


Prototype-only content:
  The content of a prototype-only block is visible only when the template is open statically but
  an executed page doesn't contain it.

  <!--/*-->
    <footer>[4] Development mode!</footer>
  <!--*/-->


Data-* syntax
=============

The data-{prefix}-{name} syntax is the standard way to write custom attributes in HTML5, without
requiring developers to use any namespaced names like th:*. Thymeleaf 2.1 makes this syntax
automatically available to all our dialects (not only the Standard ones).

This new syntax is an addition to the namespaced th:* one, it does not replace it. There is no
intention at all to deprecate the namespaced syntax in the future. 

You can use:
  <tr data-th-each="...">
  <td data-th-text="...">...</td>
  <span data-th-if="...">...</span>

instead of:
  <tr th:each="...">
  <td th:text="...">...</td>
  <span th:if="...">...</span>


Conditional th:remove
=====================

The th:remove attribute can take now any Thymeleaf Standard Expression, as long as it returns one
of the following String values:
  - all
  - tag
  - body
  - all-but-first
  - none

This means removals could now be conditional. Also note that th:remove could consider null a
synonym to none.


Conversion service
==================

The conversion service that enables us to perform data conversion and formatting operations by
means of the double-brace syntax (${{...}}) is actually a feature of the Standard Dialect, not of
the Thymeleaf Template Engine itself.

Let's assume 'price' is an instance of the Amount class and the AmountFormatter is able to convert
an instance of the Amount class to String.

Similarly, 'releaseDate' is an instance of Timestamp and TimestampFormatter is able to format it to
String.

  <dd th:text="${{price}}">$150</dd>
  <dd th:text="${{releaseDate}}">23-Jan-2014</dd>

  @Component
  public class AmountFormatter implements Formatter<Amount> {...}

  @Component
  public class TimestampFormatter implements Formatter<Timestamp> {...}


Template uri variables
======================

Because of their importance, URLs are first-class citizens in web application templates, and the
Thymeleaf Standard Dialect has a special syntax for them, the @ syntax: @{...}

There are different types of URLs:
  - Absolute URLs, like http://www.thymeleaf.org
  - Relative URLs, which can be:
    - Page-relative:
      user/login.html
    - Context-relative (context name in server will be added automatically):
      /itemdetails?id=3
    - Server-relative (allows calling URLs in another context (= application) in the same server):
      ~/billing/processInvoice
    - Protocol-relative URLs:
      //code.jquery.com/jquery-2.0.3.min.js

  <a href="buy.html" th:href="@{/buy/{id}/{name}.html(id=${productId}, name=${productName})}">Buy now!</a>

As was the case with the message syntax (#{...}), URL bases can also be the result of evaluating
another expression:

  <a th:href="@{${url}(orderId=${o.id})}">view</a>
  <a th:href="@{'/details/'+${user.login}(orderId=${o.id})}">view</a>











