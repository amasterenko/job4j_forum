<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div class="row p-4">
        <div class="col-md-6 offset-md-3">
            <div class="row p-2 justify-content-center">
                <h4>Job4j Forum</h4>
            </div>
            <div class="row p-2 justify-content-center">
                <h5>Registration:</h5>
            </div>

            <div class="row justify-content-center">
                <form action="<c:url value='/reg'/>" method='POST'>
                    <c:if test="${not empty errorMessage}">
                        <div class="alert alert-warning d-flex align-items-center" role="alert">
                                ${errorMessage}
                        </div>
                    </c:if>
                    <div class="row py-2">
                        <div class="col">
                            <label for="userName">User name</label>
                            <input type="text" name="username" id="userName" class="form-control form-control-sm"
                                   placeholder="user name" required>
                        </div>
                    </div>
                    <div class="row py-2">
                        <div class="col">
                            <label for="inputPwd">Password</label>
                            <input type="text" name="password" id="inputPwd" class="form-control form-control-sm"
                                   placeholder="password" minlength="6" required>
                        </div>
                    </div>
                    <div class="d-flex p-2 justify-content-center">
                        <a href="<c:url value='/login'/>"><small>Login</small></a>
                    </div>
                    <div class="row py-2">
                        <div class="col">
                            <button class="btn btn-lg btn-outline-dark btn-block" id="submit" type="submit">Submit
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

