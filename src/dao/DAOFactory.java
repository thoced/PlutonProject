package dao;

public class DAOFactory {

    private static DAOFactory instance = null;

    private DAOFactory(){

    }

    public static DAOFactory getInstance(){
        if(instance == null)
            instance = new DAOFactory();
        return instance;
    }

    public DAO getUserDAO() {return new UserDAO();}
    public DAO getSectionDAO() {return new SectionDAO();}
    public DAO getDossierDAO() {return new DossierDAO();}
    public DAO getIdentiteDAO() {return new IdentiteDAO();}
    public DAO getObservationDAO() {return new ObservationDAO();}


   //  public DAO getEVENT_DAO() {return new EventDAO();}

}
