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

@WebServlet("/nav")
public class NavController extends HttpServlet {
    MazeService mazeService = new MazeService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        MazeGame mazeGame = (MazeGame) session.getAttribute("playGame");


        String dir = req.getParameter("dir");

        if (dir != null) mazeService.go(mazeGame, dir);

        if (mazeGame.getPlayer().getCurrentRoom().isTarget()) {
            resp.sendRedirect("/endform");
            return;
        } else {
            String json = mazeService.getJsonInfo(mazeGame);
            req.setAttribute("myjson", json);

            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("/WEB-INF/jsp/nav.jsp");
            dispatcher.forward(req, resp);
        }
    }

}
