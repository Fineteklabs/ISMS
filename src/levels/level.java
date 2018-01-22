package levels;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by FINETEKLABS on 12/3/2017.
 */
public class level {
    private IntegerProperty levelId;
    private StringProperty levelName;
    private StringProperty levelDescription;
    private StringProperty supervisorId;
    private StringProperty currentTermId;
    private StringProperty levelFeeStructureId;
    private StringProperty levelMaxPopulation;
    private IntegerProperty levelPassMarks;
    private DoubleProperty levelFees;


    public int getLevelId() {
        return levelId.get();
    }

    public void setLevelId(int levelId) {
        this.levelId.set(levelId);
    }

    public IntegerProperty levelIdProperty() {
        return levelId;
    }

    public String getLevelName() {
        return levelName.get();
    }

    public void setLevelName(String levelName) {
        this.levelName.set(levelName);
    }

    public StringProperty levelNameProperty() {
        return levelName;
    }

    public String getLevelDescription() {
        return levelDescription.get();
    }

    public void setLevelDescription(String levelDescription) {
        this.levelDescription.set(levelDescription);
    }

    public StringProperty levelDescriptionProperty() {
        return levelDescription;
    }

    public String getSupervisorId() {
        return supervisorId.get();
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId.set(supervisorId);
    }

    public StringProperty supervisorIdProperty() {
        return supervisorId;
    }

    public String getCurrentTermId() {
        return currentTermId.get();
    }

    public void setCurrentTermId(String currentTermId) {
        this.currentTermId.set(currentTermId);
    }

    public StringProperty currentTermIdProperty() {
        return currentTermId;
    }

    public String getLevelFeeStructureId() {
        return levelFeeStructureId.get();
    }

    public void setLevelFeeStructureId(String levelFeeStructureId) {
        this.levelFeeStructureId.set(levelFeeStructureId);
    }

    public StringProperty levelFeeStructureIdProperty() {
        return levelFeeStructureId;
    }

    public String getLevelMaxPopulation() {
        return levelMaxPopulation.get();
    }

    public void setLevelMaxPopulation(String levelMaxPopulation) {
        this.levelMaxPopulation.set(levelMaxPopulation);
    }

    public StringProperty levelMaxPopulationProperty() {
        return levelMaxPopulation;
    }

    public int getLevelPassMarks() {
        return levelPassMarks.get();
    }

    public void setLevelPassMarks(int levelPassMarks) {
        this.levelPassMarks.set(levelPassMarks);
    }

    public IntegerProperty levelPassMarksProperty() {
        return levelPassMarks;
    }

    public double getLevelFees() {
        return levelFees.get();
    }

    public void setLevelFees(double levelFees) {
        this.levelFees.set(levelFees);
    }

    public DoubleProperty levelFeesProperty() {
        return levelFees;
    }
}
