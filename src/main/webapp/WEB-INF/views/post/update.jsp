<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
          crossorigin="anonymous">
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
            integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
            crossorigin="anonymous"></script>
    <title>Forum</title>
</head>
<body>
<div class="container-fluid">
    <div class="row p-2">
        <div class="col-md-6 offset-md-3">
            <div class="row p-2 justify-content-center">
                <div class="col text-center">
                    <img class="d-block mx-auto mb-4" src="/img/logo.png" alt="" width="72" height = "72">
                    <h4>Job4j Forum</h4>
                </div>
            </div>
            <div class="row p-2 justify-content-center">
                <h5>Edit post #${post.id}:</h5>
            </div>
            <div class="row justify-content-center">
                <form action="<c:url value='/save?id=${post.id}'/>" method='POST' class="was-validated">
                    <div class="row py-2">
                        <div class="col">
                            <label for="inputName">Title</label>
                            <input type="text" value="<c:out value="${post.name}"/>" name="name" id="inputName"
                                   class="form-control form-control-sm"
                                   placeholder="post title" required>
                        </div>
                    </div>
                    <div class="row py-2">
                        <div class="col">
                            <label for="inputText">Description</label>
                            <textarea class="form-control form-control-sm" rows=2 name="desc" id="inputText"
                                      placeholder="Description" required> <c:out value="${post.desc}"/>
                            </textarea>
                        </div>
                    </div>
                    <div class="d-flex p-2"></div>
                    <button class="btn btn-lg btn-outline-dark btn-block" id="submit" type="submit">Save</button>
                    <a href="<%=request.getContextPath()%>/read?id=${post.id}" class="btn btn-lg btn-secondary btn-block" role="button">Cancel</a>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
