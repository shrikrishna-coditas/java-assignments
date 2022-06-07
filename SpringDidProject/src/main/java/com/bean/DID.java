package com.bean;

import java.util.List;
import java.util.Map;

public class DID {
    private String seasonName;
    private List<String> brandPartners;
    private Map<Particpants,String> participants;

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public List<String> getBrandPartners() {
        return brandPartners;
    }

    public void setBrandPartners(List<String> brandPartners) {
        this.brandPartners = brandPartners;
    }

    public Map<Particpants, String> getParticipants() {
        return participants;
    }

    public void setParticipants(Map<Particpants, String> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "DID{" +
                "seasonName='" + seasonName + '\'' +
                ", brandPartners=" + brandPartners +
                ", participants=" + participants +
                '}';
    }
}
