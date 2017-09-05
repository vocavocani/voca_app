package com.vvn.vocavocani.question;

import java.util.ArrayList;

/**
 * Created by soo13 on 2017-09-03.
 */

public class Question {
    private String questionDesc;
    private ArrayList<Answer> answerList = new ArrayList<>();

    public Question(String questionDesc, ArrayList<Answer> answerList) {
        this.questionDesc = questionDesc;
        this.answerList = answerList;
    }

    public String getQuestionDesc() {
        return questionDesc;
    }

    public void setQuestionDesc(String questionDesc) {
        this.questionDesc = questionDesc;
    }

    public ArrayList<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(ArrayList<Answer> answerList) {
        this.answerList = answerList;
    }
}
