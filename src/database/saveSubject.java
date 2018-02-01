package database;

import java.time.LocalDate;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by FINETEKLABS on 2/1/2018.
 */
public class saveSubject {
    private static Lock lock = new ReentrantLock();
    private String subject_id;
    private String subject_name;
    private String subject_description;
    private String department_id;
    private LocalDate creation_date;
    private int subject_passmark;


    public saveSubject(subjects.subjects mysubjects) {
        this.subject_id = mysubjects.getSubjectId();
        this.subject_name = mysubjects.getSubjectName();
        this.subject_description = mysubjects.getSubjectDescription();
        this.department_id = mysubjects.getSubjectDepartment();
        this.creation_date = LocalDate.now();
        this.subject_passmark = mysubjects.getSubjectPassMark();
    }

}
