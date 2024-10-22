package prepare.interview.solid.interfacesegregation.bad;

public class FileDAOConnection implements DAOInterface {

    @Override
    public void openConnection() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void createRecord() {

    }

    @Override
    public void openFile() {

    }

    @Override
    public void deleteRecord() {

    }
}
