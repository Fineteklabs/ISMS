package database;

import java.time.LocalDate;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by FINETEKLABS on 2/1/2018.
 */
public class updateExams {


    private static Lock lock = new ReentrantLock();
    private String exam_id;
    private String exam_name;
    private String level_id;
    private String current_term;
    private LocalDate start_date;
    private LocalDate end_date;
}
