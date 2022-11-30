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
    <!-- <button type="button" class="btn btn-dark">Reset Game</button> -->
    </div>


    <script id="json" type=”application/json”> ${myjson} </script>
    <form action="/nav" method="post"></form>

    <script>
      const canvas = document.getElementById("canvas");
      const ctx = canvas.getContext("2d");
      let info = JSON.parse(document.getElementById("json").textContent);
      let numKeys=0;
      let numCoins=0;
        console.log(info);
      function defaultMap() {
        ctx.font = "20px Arial";
        ctx.fillText("Room: " + info.player.currentRoom, 10, 50);
        ctx.fillText("Keys: " + info.player.keys, 10, 75);
        ctx.fillText("Coins: " + info.player.coins, 10, 100);
        

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

         drawSide("n", info.room.walls.n.type, info.room.walls.n.open);
         drawSide("s", info.room.walls.s.type, info.room.walls.s.open);
         drawSide("e", info.room.walls.e.type, info.room.walls.e.open);
         drawSide("w", info.room.walls.w.type, info.room.walls.w.open);
         let key = info.room.key;
         let coin = info.room.coin;
         
         if(key == true ){
          drawKey();
          

         }
         if(coin == true){
          drawCoin();
         }
      }

      canvas.addEventListener("mousedown", function (e) {
        const rect = canvas.getBoundingClientRect();
        const x = event.clientX - rect.left;
        const y = event.clientY - rect.top;
        console.log("x: " + x + " y: " + y);
        
        if (79.5 <= x && x <= 122 && 426 <= y && y <= 459) {
          console.log("up");
          if(info.room.walls.n.open){
          window.location.assign("/nav?dir=N");
        }else{
            ctx.fillText("no pots passar " , 150, 30);
          }
        }
        if (44 <= x && x <= 85 && 456 <= y && y <= 499) {
          console.log("left");
          if(info.room.walls.w.open){
          window.location.assign("/nav?dir=W");
          }else{
            ctx.fillText("no pots passar " , 150, 30);
          }
        }
        if (77 <= x && x <= 127 && 500 <= y && y <= 531) {
          console.log("down");
          if(info.room.walls.s.open){
          window.location.assign("/nav?dir=S");
            
          }else{
            ctx.fillText("no pots passar" , 150, 30);
          }
        }
        if (126 <= x && x <= 160 && 455 <= y && y <= 500) {
          console.log("right");
          if(info.room.walls.e.open){
            window.location.assign("/nav?dir=E"); 
            
          }else{
            ctx.fillText("no pots passar" , 150, 30);
          }
          
        }

        if(231 <= x && x <= 366 && 393 <= y && y <= 526 && info.room.key == true){
          ctx.clearRect(231, 393, 135, 133);
          window.location.assign("/getkey"); 
          ctx.fillText("Has obtingut una clau" , 150, 30);
          console.log("Has obtingut una clau");
        }

        if(511 <= x && x <= 662 && 417 <= y && y <= 538 && info.room.coin == true){
          ctx.clearRect(511, 410, 161, 131);
          window.location.assign("/getcoin"); 
          ctx.fillText("Has obtingut una moneda" , 150, 30);
          console.log("Has obtingut una moneda");
        }
        //puerta izquierda
        if(198 <= x && x <= 222 && 248 <= y && y <= 350 && !info.room.walls.w.open){
          window.location.assign("/open?dir=W"); 
        }
        //puerta derecha
        if(679 <= x && x <= 700 && 251 <= y && y <= 351 && !info.room.walls.e.open){
          window.location.assign("/open?dir=E"); 
        }

        //puerta arriba
        if(398 <= x && x <= 505 && 48 <= y && y <= 75 && !info.room.walls.n.open){
          window.location.assign("/open?dir=N"); 
        }
        //puerta abajo
        if(400 <= x && x <= 501 && 548 <= y && y <= 572 && !info.room.walls.s.open){
          window.location.assign("/open?dir=S"); 
        }
      });

      function drawSide(side, type, doorOpen) {
        if (type == "wall") {
            drawWalls(side);
        } else {
            if (!doorOpen) {
                drawDoors(side);
            }
        }
      }

            
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

      function drawWalls(side){

        ctx.fillStyle = "black";
        //muro de abajo
        if(side=="s"){
        ctx.fillRect(400, 550, 100, 20);
        }
        //muro de arriba
        if(side=="n"){
        ctx.fillRect(400, 50, 100, 20);
        }
        //muro izquierda
        if(side=="w"){
        ctx.fillRect(200, 250, 20, 100);
        }
        //muro derecha
        if(side=="e"){
        ctx.fillRect(680, 250, 20, 100);
        }
      }

      function drawDoors(side){
        ctx.fillStyle = "red";
        //muro de abajo
          
          if(side=="s"){
          ctx.fillRect(400, 550, 100, 20);
          }
          //muro de arriba
          if(side=="n"){
          ctx.fillRect(400, 50, 100, 20);
          }
          //muro izquierda
          if(side=="w"){
          ctx.fillRect(200, 250, 20, 100);
          }
          //muro derecha
          if(side=="e"){
          ctx.fillRect(680, 250, 20, 100);
          }
      
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
