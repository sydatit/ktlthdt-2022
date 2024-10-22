package prepare.interview.solid.interfacesegregation.bad;

public interface DAOInterface {
    void openConnection();
    void createRecord();
    void openFile();
    void deleteRecord();
}
