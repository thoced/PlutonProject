package dao;

import config.SingletonConnection;
import models.DossierModel;
import models.ObservationModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @class class DAO pour les observations
 * @author thonon cedric
 */

public class ObservationDAO extends DAO<ObservationModel> {
    @Override
    public void insert(ObservationModel model) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("insert into t_observations (namefile,comment,ref_id_dossiers) VALUES (?,?,?)");
        ps.setString(1,model.getNamefile());
        ps.setString(2,model.getComment());
        ps.setLong(3,model.getRef_id_dossiers());
        ps.executeUpdate();
        ps.close();

    }

    @Override
    public void delete(long id) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("delete from t_observations where id = ?");
        ps.setLong(1,id);
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void update(ObservationModel model) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("update t_observations SET namefile = ?," +
                "comment = ?, " +
                "ref_id_dossiers = ? WHERE id = ?");
        ps.setString(1,model.getNamefile());
        ps.setString(2,model.getComment());
        ps.setLong(3,model.getRef_id_dossiers());
        ps.setLong(4,model.getId());
        ps.executeUpdate();
        ps.close();

    }

    @Override
    public ObservationModel find(long id) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("select * from t_observations where id = ?");
        ps.setLong(1,id);
        ResultSet resultSet = ps.executeQuery();
        ObservationModel model = new ObservationModel();
        while(resultSet.next()){
            model.setId(resultSet.getLong("id"));
            model.setNamefile(resultSet.getString("namefile"));
            model.setComment(resultSet.getString("comment"));
            model.setRef_id_dossiers(resultSet.getLong("ref_id_dossiers"));
        }
        ps.close();
        return model;
    }

    @Override
    public List<ObservationModel> selectAll() throws SQLException {
        Statement st = SingletonConnection.getInstance().getConnection().createStatement();
        ResultSet resultSet  = st.executeQuery("select * from t_observations");
        List<ObservationModel> list = new ArrayList<ObservationModel>();
        while(resultSet.next()){
            ObservationModel model = new ObservationModel();
            model.setId(resultSet.getLong("id"));
            model.setNamefile(resultSet.getString("namefile"));
            model.setComment(resultSet.getString("comment"));
            model.setRef_id_dossiers(resultSet.getLong("ref_id_dossiers"));
            list.add(model);
        }
        st.close();
        return list;
    }

    @Override
    public List<ObservationModel> selectAll(int orderingBy, boolean direction) throws SQLException {
        return null;
    }

    @Override
    public List<ObservationModel> selectFromForeignKey(long id) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("select * from t_observations where ref_id_dossiers = ?");
        ps.setLong(1,id);
        ResultSet resultSet = ps.executeQuery();
        List<ObservationModel> list = new ArrayList<ObservationModel>();
        while(resultSet.next()){
            ObservationModel model = new ObservationModel();
            model.setId(resultSet.getLong("id"));
            model.setNamefile(resultSet.getString("namefile"));
            model.setComment(resultSet.getString("comment"));
            model.setRef_id_dossiers(resultSet.getLong("ref_id_dossiers"));
            list.add(model);
        }
        ps.close();
        return list;
    }
}
