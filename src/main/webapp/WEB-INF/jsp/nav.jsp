<%@ page isELIgnored="false" %> <%@ taglib uri
="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ page
contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
      crossorigin="anonymous"
    />
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>MAZEGAME</title>
    <link rel="stylesheet" href="../../css/canvas.css" />
  </head>

  <body style="background-image: url(https://wallpapers.com/images/hd/white-textured-paper-439vozmsl9bybc8a.jpg); " onload="defaultMap()">
    <h1>MAZE GAME</h1>
    <div id="clase" class="clase">
      <canvas id="canvas" class="canvas" width="800" height="600" style="background-color: white; border: solid black 1px"></canvas>
    </div>
    <form action="/nav" method="post"></form>

    <script>
      const canvas = document.getElementById("canvas");
      const ctx = canvas.getContext("2d");

      function defaultMap() {
        ctx.font = "20px Arial";
        ctx.fillText("Room:", 10, 50);
        ctx.fillText("Keys:", 10, 75);
        ctx.fillText("Coins:", 10, 100);

        let personaje = new Image();
        let joystick = new Image();
        personaje.src = "./img/Doom-PNG-Clipart.png";
        joystick.src = "./img/5898166.png";


        personaje.onload = function () {
          ctx.drawImage(personaje, 370, 225, 150, 136);
        };

        joystick.onload = function () {
          ctx.drawImage(joystick, 17, 400, 170, 156);
        };

        //arriba
        ctx.fillRect(200, 50, 20, 200);
        ctx.fillRect(680, 50, 20, 200);

        //rectangulos arribaLados
        ctx.fillRect(200, 50, 200, 20);
        ctx.fillRect(500, 50, 200, 20);

        // //rectangulos abajo
        ctx.fillRect(200, 550, 200, 20);
        ctx.fillRect(500, 550, 200, 20);

        ctx.fillRect(200, 350, 20, 200);
        ctx.fillRect(680, 350, 20, 200);

        drawKey();
        drawCoin();
        drawWalls();
        drawDoors();
      }

      canvas.addEventListener("mousedown", function (e) {
        const rect = canvas.getBoundingClientRect();
        const x = event.clientX - rect.left;
        const y = event.clientY - rect.top;
        console.log("x: " + x + " y: " + y);

        if (79.5 <= x && x <= 122 && 426 <= y && y <= 459) {
          console.log("up");
        }
        if (44 <= x && x <= 85 && 456 <= y && y <= 499) {
          console.log("left");
        }
        if (77 <= x && x <= 127 && 500 <= y && y <= 531) {
          console.log("down");
        }
        if (126 <= x && x <= 160 && 455 <= y && y <= 500) {
          console.log("right");
        }
      });

      function drawKey(){
        let key = new Image();
        key.src = "./img/key.webp";
        key.onload = function () {
          ctx.drawImage(key, 220, 390, 160, 146);
        };


      }

      function drawCoin(){
        let coin = new Image();
        coin.src = "./img/coin.png";
        coin.onload = function () {
          ctx.drawImage(coin, 530, 410, 140, 130);
        };

      }

      function drawWalls(){

        ctx.fillStyle = "black";
        //muro de abajo
        ctx.fillRect(400, 550, 100, 20);

        //muro de arriba
        ctx.fillRect(400, 50, 100, 20);

        //muro izquierda
        ctx.fillRect(200, 250, 20, 100);

        //muro derecha

        ctx.fillRect(680, 250, 20, 100);

      }

      function drawDoors(){
        ctx.fillStyle = "red";
        //muro de abajo
        ctx.fillRect(400, 550, 100, 20);

        //muro de arriba
        ctx.fillRect(400, 50, 100, 20);

        //muro izquierda
        ctx.fillRect(200, 250, 20, 100);

        //muro derecha

        ctx.fillRect(680, 250, 20, 100);

      }



    </script>

    <script
      src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
      integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
      integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
      integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
