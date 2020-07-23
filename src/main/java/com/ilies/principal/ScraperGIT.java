package com.ilies.principal;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ScraperGIT {
    // une constante qui contient l'URL de l'API utilisée
    private final static String baseURL = "https://api.github.com/search/repositories?q=json&page=1&per_page=1000";

    /*
        Fonction contenant le Script de scraping
     */
    public void executerScript() {
        try {
            URL obj = new URL(baseURL); //Variable contenant l'URL
            HttpURLConnection con = (HttpURLConnection) obj.openConnection(); //
            con.setRequestMethod("GET"); // Utilisation de la requête
            con.setRequestProperty("User-Agent", "Mozilla/5.0"); //application cliente
            BufferedReader in = new BufferedReader(new InputStreamReader((con.getInputStream()))); //lecture à partir de la connexion
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) { //Lecture du contenu de la variable
                response.append(inputLine); //ajout de celle - ci dans response

            }
            in.close(); //fermeture de la lecture

            JSONObject obj_Repos = new JSONObject(response.toString()); //création d'un objet JSON
            JSONArray obj_plrsRepos = obj_Repos.getJSONArray("items"); //création d'une liste JSON contenant ce qui appartient à items

            for (int i = 0; i < obj_plrsRepos.length(); i++) { //parcours de la liste
                JSONObject obj_unRepo = new JSONObject();
                obj_unRepo = obj_plrsRepos.getJSONObject(i); //récupération de chaque repo


                /*
                * Affichage des informations récoltées
                */
                System.out.println("Nom du répertoire : " + obj_unRepo.getString("full_name").toString());
                System.out.println("URL du répertoire : " + "https://github.com/" + obj_unRepo.getString("full_name").toString());
                System.out.println("Description du répertoire : " + obj_unRepo.getString("description").toString());
                System.out.println("Nombre d'étoiles obtenu par le répertoire : " + obj_unRepo.getInt("stargazers_count"));
                System.out.print("-------------------------------------------");
                System.out.println(" ");
            }

        } catch (Exception e) { //si une erreur survient
            e.printStackTrace();
        }
    }
}

