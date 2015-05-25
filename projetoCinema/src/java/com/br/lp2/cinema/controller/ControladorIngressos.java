/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.cinema.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo
 */
public class ControladorIngressos extends HttpServlet {

    private String command;
    private ArrayList<Integer> cadeiras;
    private ArrayList<List<Integer>> salas;
    private int sala_selecionada;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if ("init".equals(command)) {
                cadeiras = new ArrayList<Integer>();
                for (int i = 0; i < 60; i++) {
                    cadeiras.add(0);
                }

                salas = new ArrayList<List<Integer>>();
                ArrayList<Integer> sala1 = new ArrayList<>();
                sala1.add(1);
                sala1.add(2);
                sala1.add(3);
                sala1.add(4);
                sala1.add(5);
                salas.add(sala1);

                ArrayList<Integer> sala2 = new ArrayList<>();
                sala2.add(1);
                sala2.add(2);
                salas.add(sala2);

                sala_selecionada = 0;

                request.getSession().setAttribute("sala_selecionada", sala_selecionada);
                request.getSession().setAttribute("salas", salas);
                request.getSession().setAttribute("cadeiras", cadeiras);

            } else if (command.startsWith("selecionar")) {
                int numero = Integer.parseInt(command.split(".cad")[1]);
                if (cadeiras.get(numero) == 0) {
                    cadeiras.set(numero, 1);
                } else if (cadeiras.get(numero) == 1) {
                    cadeiras.set(numero, 0);
                }
            } else if ("comprar".equals(command)) {
                for (int i = 0; i < cadeiras.size(); i++) {
                    if (cadeiras.get(i) == 1) {
                        cadeiras.set(i, 2);
                    }

                }
            } else if (command.startsWith("trocasala")) {
                int numero = Integer.parseInt(command.split("trocasala.")[1]);
                sala_selecionada = numero;
                request.getSession().setAttribute("sala_selecionada", sala_selecionada);
            }

            response.sendRedirect("comprar_ingresso.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        command = request.getParameter("command");

        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
