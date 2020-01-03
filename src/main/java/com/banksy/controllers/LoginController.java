package com.banksy.controllers;

import com.banksy.models.Personne;
import com.banksy.validators.XMLValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.banksy.constants.ClasseXMLConstants.viewPath;

@WebServlet("/")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(viewPath + "authentification.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Personne personne = XMLValidator.validateLoginXML(req);
        if (personne != null) {
            if (personne.getProfil().equals("etudiant")) {
                req.setAttribute("personne", personne);
                this.getServletContext().getRequestDispatcher(viewPath + "etudiant.jsp").forward(req, resp);
            } else
                this.getServletContext().getRequestDispatcher(viewPath + "formProf.jsp").forward(req, resp);
        } else this.getServletContext().getRequestDispatcher(viewPath + "authentification.jsp").forward(req, resp);

    }
}
