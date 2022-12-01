package com.liceu.maze.controllers;

import com.liceu.maze.services.MazeGame;
import com.liceu.maze.services.MazeService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/start")
public class StartController extends HttpServlet {

    MazeService mazeService = new MazeService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("mazeList", mazeService.mazeList());

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/start.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        try {
            Date time = new Date();
            int mapId = Integer.parseInt(req.getParameter("maps"));
            MazeGame playGame = mazeService.createMazeGame(mapId);

            session.setAttribute("playGame", playGame);
            session.setAttribute("time", time.getTime());

        } catch (NumberFormatException e) {

        }
        resp.sendRedirect("/nav");

    }


}
