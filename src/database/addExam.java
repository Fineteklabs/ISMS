package database;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by FINETEKLABS on 1/29/2018.
 */
public class addExam implements Runnable {
    private static Lock lock = new ReentrantLock();
    private String exam_id;
    private String exam_name;
    private String level_id;
    private String current_term;
    private String start_date;
    private String end_date;
   

    @Override
    public void run() {

    }
}
