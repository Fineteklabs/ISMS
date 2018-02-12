package guardians;

import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 * A service for getting the DailySales data. This service exposes an
 * ObservableList for convenience when using the service. This
 * <code>results</code> list is final, though its contents are replaced when a
 * service call successfully concludes.
 */
public class EmployeeTask extends Service<ObservableList<employees.employee>> {

    /**
     * Create and return the task for fetching the data. Note that this method
     * is called on the background thread (all other code in this application is
     * on the JavaFX Application Thread!).
     */
    @Override
    protected Task createTask() {


        return new employeeList();
    }
}