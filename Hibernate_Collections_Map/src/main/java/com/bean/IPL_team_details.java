package com.bean;

import java.util.Map;

public class IPL_team_details {
    private int tid;
    private String team_name;
    private String owner_name;

    private Map<String,Players> players;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public Map<String, Players> getPlayers() {
        return players;
    }

    public void setPlayers(Map<String, Players> players) {
        this.players = players;
    }
}
