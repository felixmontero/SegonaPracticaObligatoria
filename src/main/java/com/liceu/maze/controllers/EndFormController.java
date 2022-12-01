package com.liceu.maze.controllers;

import com.liceu.maze.services.MazeGame;
import com.liceu.maze.services.SqlService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/endform")
public class EndFormController extends HttpServlet {
    SqlService sqlService = new SqlService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Date endTime = new Date();
       /* int time =(int) session.getAttribute("time");
        int timeToScape =(int) endTime.getTime() - time;
        session.setAttribute("TimeToScape",timeToScape);
        System.out.println(timeToScape+""); */
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/endForm.jsp");
        dispatcher.forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        MazeGame mazeGame = (MazeGame) session.getAttribute("playGame");
        String name= req.getParameter("user");
        String mapName = mazeGame.getMaze().getName();
        Date time= new Date();

        try {
            sqlService.setWinners(name,mapName,time.getTime());
        }catch (Exception e){

        }
        resp.sendRedirect("/winners");
    }
}
