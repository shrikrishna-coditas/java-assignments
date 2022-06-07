package com.bean;

import java.util.List;

public class SingerSongs {
    private String singerName;
    private String singerDOB;
    private int singerAge;
    List<String> songList;

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSingerDOB() {
        return singerDOB;
    }

    public void setSingerDOB(String singerDOB) {
        this.singerDOB = singerDOB;
    }

    public int getSingerAge() {
        return singerAge;
    }

    public void setSingerAge(int singerAge) {
        this.singerAge = singerAge;
    }

    public List<String> getSongList() {
        return songList;
    }

    public void setSongList(List<String> songList) {
        this.songList = songList;
    }

    @Override
    public String toString() {
        return "SingerSongs{" +
                "singerName='" + singerName + '\'' +
                ", singerDOB='" + singerDOB + '\'' +
                ", singerAge=" + singerAge +
                ", songList=" + songList +
                '}';
    }
}
