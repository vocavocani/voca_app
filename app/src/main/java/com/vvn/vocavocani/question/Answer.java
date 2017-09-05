package com.vvn.vocavocani.question;

/**
 * Created by soo13 on 2017-09-03.
 */

public class Answer {
    private int id;
    private boolean checked;
    private String answerText;

    public Answer() {
    }

    public Answer(int id, boolean checked, String answerText) {
        this.id = id;
        this.checked = checked;
        this.answerText = answerText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }
}
