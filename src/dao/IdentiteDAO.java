package dao;

import config.SingletonConnection;
import models.IdentiteModel;
import models.UserModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @class class DAO pour les identités
 * @author thonon cedric
 */

public class IdentiteDAO extends DAO<IdentiteModel> {

    @Override
    public void insert(IdentiteModel model) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("insert into t_identites (numero,identite,ref_id_dossiers) VALUES (?,?,?)");
        ps.setString(1,model.getNumero());
        ps.setString(2,model.getIdentite());
        ps.setLong(3,model.getRef_id_dossiers());
        ps.executeUpdate();

    }

    @Override
    public void delete(long id) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("delete from t_identites where id = ?");
        ps.setLong(1,id);
        ps.executeUpdate();

    }

    @Override
    public void update(IdentiteModel model) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("update t_identites SET numero = ?," +
                "identite = ?," +
                "WHERE id = ?");
        ps.setString(1,model.getNumero());
        ps.setString(2,model.getIdentite());
        ps.setLong(3,model.getId());
        ps.executeUpdate();

    }

    @Override
    public IdentiteModel find(long id) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("select * from t_identites where id = ?");
        ps.setLong(1,id);
        ResultSet resultSet = ps.executeQuery();
        IdentiteModel model = new IdentiteModel();
        while(resultSet.next()){
            model.setId(resultSet.getLong("id"));
            model.setNumero(resultSet.getString("numero"));
            model.setIdentite(resultSet.getString("identite"));
            model.setRef_id_dossiers(resultSet.getLong("ref_id_dossiers"));
        }
        return model;
    }

    public List<IdentiteModel> findNumero(String numero) throws SQLException {
        String search = "%" + numero.trim() + "%";
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("select * from t_identites where numero LIKE ?");
        ps.setString(1,search);
        ResultSet resultSet = ps.executeQuery();
        List<IdentiteModel> list = new ArrayList<IdentiteModel>();
        while(resultSet.next()){
            IdentiteModel model = new IdentiteModel();
            model.setId(resultSet.getLong("id"));
            model.setNumero(resultSet.getString("numero"));
            model.setIdentite(resultSet.getString("identite"));
            model.setRef_id_dossiers(resultSet.getLong("ref_id_dossiers"));
            list.add(model);
        }
        return list;
    }

    public List<IdentiteModel> findIdentite(String identite) throws SQLException {
        String search = "%" + identite.trim() + "%";
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("select * from t_identites where identite LIKE ?");
        ps.setString(1,search);
        ResultSet resultSet = ps.executeQuery();
        List<IdentiteModel> list = new ArrayList<IdentiteModel>();
        while(resultSet.next()){
            IdentiteModel model = new IdentiteModel();
            model.setId(resultSet.getLong("id"));
            model.setNumero(resultSet.getString("numero"));
            model.setIdentite(resultSet.getString("identite"));
            model.setRef_id_dossiers(resultSet.getLong("ref_id_dossiers"));
            list.add(model);
        }
        return list;
    }

    @Override
    public List<IdentiteModel> selectAll() throws SQLException {
        Statement st = SingletonConnection.getInstance().getConnection().createStatement();
        ResultSet resultSet  =st.executeQuery("select * from t_identites");
        List<IdentiteModel> list = new ArrayList<IdentiteModel>();
        while(resultSet.next()){
            IdentiteModel model = new IdentiteModel();
            model.setId(resultSet.getLong("id"));
            model.setNumero(resultSet.getString("numero"));
            model.setIdentite(resultSet.getString("identite"));
            model.setRef_id_dossiers(resultSet.getLong("ref_id_dossiers"));
            list.add(model);
        }
        return list;
    }

    @Override
    public List<IdentiteModel> selectFromForeignKey(long id) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("select * from t_identites where ref_id_dossiers = ?");
        ps.setLong(1,id);
        ResultSet resultSet = ps.executeQuery();
        List<IdentiteModel> list = new ArrayList<IdentiteModel>();
        while(resultSet.next()){
            IdentiteModel model = new IdentiteModel();
            model.setId(resultSet.getLong("id"));
            model.setNumero(resultSet.getString("numero"));
            model.setIdentite(resultSet.getString("identite"));
            model.setRef_id_dossiers(resultSet.getLong("ref_id_dossiers"));
            list.add(model);
        }
        return list;
    }
}
