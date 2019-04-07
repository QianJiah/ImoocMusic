package com.qjh.imoocmusic.entities;

public class MusicInfo {
    private String musicName;
    private String musicAuthor;

    public MusicInfo(String musicName, String musicAuthor) {
        this.musicName = musicName;
        this.musicAuthor = musicAuthor;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicAuthor() {
        return musicAuthor;
    }

    public void setMusicAuthor(String musicAuthor) {
        this.musicAuthor = musicAuthor;
    }
}
