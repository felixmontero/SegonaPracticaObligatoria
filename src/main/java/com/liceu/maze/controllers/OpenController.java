package com.liceu.maze.controllers;

import com.liceu.maze.services.MazeGame;
import com.liceu.maze.services.MazeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/open")
public class OpenController extends HttpServlet {
    MazeService mazeService = new MazeService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        MazeGame mazeGame = (MazeGame) session.getAttribute("playGame");


        String dir = req.getParameter("dir");

        if(dir!=null) mazeService.openDoor(mazeGame,dir);

        resp.sendRedirect("/nav");
    }
}
