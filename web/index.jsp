<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
  <style>
    * {
      margin: 0px;
      padding: 0px;
    }
    .t1{
      text-align: center;
    }
  </style>
</head>

<body>
<center>
  <h1 style="margin-top: 20vh;margin-bottom: 20px;">学生信息表</h1>
  <table class="t1" border="1" cellspacing="0" width="500px">
    <thead>
      <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>电话</th>
        <th>邮箱</th>
      </tr>
    </thead>
    <tbody class="tbody">
    </tbody>
  </table>
</center>

<template id="tp">
  <tr class="row">
    <td class="r1">a</td>
    <td class="r1">b</td>
    <td class="r1">c</td>
    <td class="r1">d</td>
    <td class="r1">e</td>
    <td class="r1">f</td>
  </tr>
</template>

</body>
<script>
  function x() {
    $.post("user",function (data){
      const tp = document.getElementById("tp");
      const row = tp.content;
      const [c1,c2,c3,c4,c5,c6] = row.querySelectorAll(".r1")
      const tbody = document.querySelector(".tbody")
      for (user of JSON.parse(data)){
        c1.textContent=user.id;
        c2.textContent=user.name;
        c3.textContent=user.sex;
        c4.textContent=user.age;
        c5.textContent=user.tel;
        c6.textContent=user.email;
        const newrow = document.importNode(row,true)
        tbody.appendChild(newrow);
      }
      console.log(data)
    })
  }
  x();
</script>
</html>