package classification;

import java.time.LocalDate;

/**
 * Created by FINETEKLABS on 7/9/2017.
 */
public interface classification {


    public String getClassificationName();


    public default String classificationGroup() {
        return null;
    }

    public String getClassificationId();


    public String getTargetGroup();


    public Double getTaxRate();


    public Double getInsuranceRate();


    public Double getDividendsRate();

    public LocalDate creationDate();


    public LocalDate scheduleReviewDate();


    public Double minimmumIncome();


    public Double maximmumIncome();


    public String getDescription();
}
