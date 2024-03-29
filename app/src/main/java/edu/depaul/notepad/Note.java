package edu.depaul.notepad;

import java.text.SimpleDateFormat;

import java.util.Date;

public class Note {
    private String title;
    private String noteText;
    private String time;

    public Note(String title_, String noteText_)
    {
        title=title_;
        noteText=noteText_;
        //getting current time and parsing it to String
        SimpleDateFormat  dtf = new SimpleDateFormat ("MM/dd/yyyy HH:mm");
        Date date=new Date();
        time=dtf.format(date);

    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getNoteText() {
        return noteText;
    }

    public String getTime() {
        return time;
    }
}
