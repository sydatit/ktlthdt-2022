package prepare.interview.solid.interfacesegregation.bad;

public class DBDAOConnection implements DAOInterface{
    @Override
    public void openConnection() {

    }

    @Override
    public void createRecord() {

    }

    @Override
    public void openFile() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteRecord() {

    }
}
