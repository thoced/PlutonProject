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

   //  public DAO getEVENT_DAO() {return new EventDAO();}

}
