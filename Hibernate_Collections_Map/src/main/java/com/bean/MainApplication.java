package com.bean;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        Configuration configuration=new Configuration().configure("hibernate.cfg.xml");
        SessionFactory  sessionFactory=configuration.buildSessionFactory();
        Session session=sessionFactory.openSession();


        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("How many teams you want to add?");
        int teams=Integer.parseInt(br.readLine());

        for(int i=0;i<teams;i++){
            Transaction transaction=session.beginTransaction();
            System.out.println("Enter team "+(i+1)+" details");
            System.out.println("Enter team name");
            String tname=br.readLine();
            System.out.println("Enter owner name");
            String oname= br.readLine();

            System.out.println("How many players you want to add?");
            int players=Integer.parseInt(br.readLine());

            String country=null;;
            Map<String,Players> pmap=new HashMap<>();
            for(int j=0;j<players;j++){
                System.out.println("Enter player id");
                int pid=Integer.parseInt(br.readLine());
                System.out.println("Enter player name");
                String pname=br.readLine();
                System.out.println("Enter bid value");
                int bid_value=Integer.parseInt(br.readLine());
                System.out.println("Enter the country");
                country=br.readLine();

                Players player=new Players();
                player.setPid(pid);
                player.setPname(pname);
                player.setBid_value(bid_value);
                pmap.put(country,player);
            }

            IPL_team_details iplTeamDetails=new IPL_team_details();
            iplTeamDetails.setTeam_name(tname);
            iplTeamDetails.setOwner_name(oname);
            iplTeamDetails.setPlayers(pmap);

            session.save(iplTeamDetails);
            transaction.commit();
        }

    }
}
