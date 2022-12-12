<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2022-12-09
  Time: 오후 6:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <link rel="stylesheet" href="https://unpkg.com/mvp.css@1.12/mvp.css">
    <script>
        const msg = "${msg}";
        if (msg === "wrong")
        {
            alert("아이디나 비밀번호가 일치하지 않습니다. 다시 시도해주세요.");
        }
        else if (msg === "bye")
        {
            alert("로그아웃되었습니다. 이용해주셔서 감사합니다.");
        }
    </script>
</head>
<body>
    <div style='text-align: center; padding-top: 100px'>
        <img src='../img/pancake.jpg' height = 250>
        <form style="width: 250px; margin: 0 auto" action="login_ok" method="POST">
            <div><label>사용자 ID</label><input style="width: 250px" type='text' name='userid' /></div>
            <div><label>비밀번호</label><input style="width: 250px" type='password' name='password' /></div>
            <button type='submit'>로그인</button>
        </form>
    </div>
</body>
</html>
