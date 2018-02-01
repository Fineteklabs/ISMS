package levels;

import javafx.beans.property.*;

/**
 * Created by FINETEKLABS on 12/3/2017.
 */
public class level {


    private final StringProperty levelId = new SimpleStringProperty(this, "levelId", null);
    private final StringProperty levelName = new SimpleStringProperty(this, "levelName", null);
    private final StringProperty levelDescription = new SimpleStringProperty(this, "levelDescription", null);
    private final StringProperty supervisorId = new SimpleStringProperty(this, "supervisorId", null);
    private final StringProperty currentTermId = new SimpleStringProperty(this, "currentTermId", null);
    private final StringProperty levelFeeStructureId = new SimpleStringProperty(this, "levelFeeStructureId", null);
    private final IntegerProperty levelMaxPopulation = new SimpleIntegerProperty(this, "levelMaxPopulation", 0);
    //private final StringProperty levelPassMarks = new SimpleStringProperty(this, "supervisorId", null);
    private final DoubleProperty levelFees = new SimpleDoubleProperty(this, "levelFees", 0.0);
    private final IntegerProperty levelPassMarks = new SimpleIntegerProperty(this, "levelPassMarks", 0);


    public level() {

    }

    public level(String levelId, String levelName, String levelDescription, String supervisorId, String currentTermId, String levelFeeStructureId, Integer levelMaxPopulation, Double levelFees, Integer levelPassMark) {
        this.currentTermId.set(currentTermId);
        this.levelId.set(levelId);
        this.levelName.set(levelName);
        this.levelDescription.set(levelDescription);
        this.supervisorId.set(supervisorId);
        this.levelFeeStructureId.set(levelFeeStructureId);
        this.levelFees.set(levelFees);
        this.levelPassMarks.set(levelPassMark);
        this.levelMaxPopulation.set(levelMaxPopulation);


    }


    public int getLevelMaxPopulation() {
        return levelMaxPopulation.get();
    }

    public void setLevelMaxPopulation(int levelMaxPopulation) {
        this.levelMaxPopulation.set(levelMaxPopulation);
    }

    public IntegerProperty levelMaxPopulationProperty() {
        return levelMaxPopulation;
    }

    public String getLevelId() {
        return levelId.get();
    }

    public void setLevelId(String levelId) {
        this.levelId.set(levelId);
    }

    public StringProperty levelIdProperty() {
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
