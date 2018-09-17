package com.tuanpv.quickanswerapi.activitys;

/**
 * Created by TuanPV on 8/29/2018.
 */

public class QuestionLibrary {
    private String mQuestion[] = {
            "Question 1",
            "Question 2",
            "Question 3",
    };

    private String mChoice[][] = {
            {"AQ11", "AQ12", "AQ13"},
            {"AQ21", "AQ22", "AQ23"},
            {"AQ31", "AQ32", "AQ33"},
    };

    private String mCorrectAnswer[] = {
            "AQ11","AQ22","AQ33"
    };

    public String getQuestion(int a){
        String question = mQuestion[a];
        return question;
    }

    public String getChoice(int a, int index){
        String choice = mChoice[a][index];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswer[a];
        return answer;
    }

    public int getCountQuestion(){
        return mQuestion.length;
    }
}
