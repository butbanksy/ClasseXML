package com.banksy.validators;


import com.banksy.models.Personne;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class XMLValidator {

    static org.jdom.Document document;
    static org.jdom.Element element;


    public static Personne validateLoginXML(HttpServletRequest req) {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            document = saxBuilder.build(new File("examen.xml"));
        } catch (IOException | JDOMException e) {
            e.printStackTrace();
        }
        element = document.getRootElement();
        Collection listeEtudiants = element.getChildren("personne");
        Iterator i = listeEtudiants.iterator();
        while (i.hasNext()) {
            Element courant = (Element) i.next();
            System.out.println("nom : " + courant.getChild("nom").getText());
            if (courant.getChild("login").getText().equals(login) && courant.getChild("password").getText().equals(password)) {
                Personne personne = new Personne();
                personne.setNom(courant.getChild("nom").getText());
                personne.setPrenom(courant.getChild("prenom").getText());
                if (courant.getChild("profil").getText().equals("etudiant")) {
                    personne.setProfil(courant.getChild("profil").getText());
                    personne.setNote(courant.getChild("note").getText());
                    return personne;
                } else {
                    personne.setProfil(courant.getChild("profil").getText());
                    personne.setMatiere(courant.getChild("matiere").getText());
                    return personne;
                }
            }
        }
        return null;
    }
}
