/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;
import org.apache.http.client.fluent.Request;
/**
 *
 * @author mluukkai
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
//        System.out.println("json-muotoinen data:");
//        System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
//        System.out.println("Oliot:");
//        for (Player player : players) {
//            System.out.println(player);
//        } 
        System.out.println("Players from FIN Wed Nov 06 23:47:11 EET 2019");
        Arrays.sort(players);
        for (Player p : players) {
            if (p.getNationality().equals("FIN")) {
                System.out.println(p.getName() + " " + p.getTeam() + " " + p.getGoals() + " + " + p.getAssists() + " = " + (p.getGoals()+p.getAssists()));
            }
        }
    }
}
