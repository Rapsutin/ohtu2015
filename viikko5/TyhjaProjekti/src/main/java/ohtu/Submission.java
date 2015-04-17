package ohtu;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Submission {
    private String student_number;
    int week;
    int hours;
    boolean a1;
    boolean a2;
    boolean a3;
    boolean a4;
    boolean a5;
    boolean a6;
    boolean a7;
    boolean a8;
    boolean a9;
    boolean a10;
    boolean a11;
    boolean a12;
    boolean a13;
    boolean a14;
    boolean a15;

    

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    @Override
    public String toString() {
        boolean[] doneSubmissions = doneSubmissions();
        int submissions = numberOfSubmissions(doneSubmissions);
        ArrayList<Integer> submissionNumbers = doneSubmissionNumbers(doneSubmissions);
        
        return "viikko "+week+": tehtyjä tehtäviä yhteensä "+submissions +"\n"
               + "tehdyt: "+ submissionNumbers + "\n"
               + "aikaa kului: "+hours;
    }

    private int numberOfSubmissions(boolean[] doneSubmissions) {
        int done = 0;
        for (int i = 0; i < doneSubmissions.length; i++) {
            if(doneSubmissions[i]) done++;
        }
        return done;
    }
    
    private boolean[] doneSubmissions() {
        Class c = this.getClass();
        boolean[] submissions = new boolean[16];
        try {
            for (int i = 1; i <= 15; i++) {
                Field f = c.getDeclaredField("a"+i);
                submissions[i] = f.getBoolean(this);
            }
        } catch (Exception e){}
        
        return submissions;
    }
    
    private ArrayList<Integer> doneSubmissionNumbers(boolean[] doneSubmissions) {
        ArrayList<Integer> doneSubmissionNumbers = new ArrayList<Integer>();
        for (int i = 0; i < doneSubmissions.length; i++) {
            if(doneSubmissions[i]) doneSubmissionNumbers.add(i);
        }
        return doneSubmissionNumbers;
    }
    
}