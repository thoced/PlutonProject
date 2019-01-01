package dao;

import config.SingletonConnection;
import models.IdentiteModel;
import models.UserModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @class class DAO pour les identités
 * @author thonon cedric
 */

public class IdentiteDAO extends DAO<IdentiteModel> {

    @Override
    public void insert(IdentiteModel model) throws SQLException {

        PreparedStatement ps = null;
        try {
            SingletonConnection.getInstance().getConnection().setAutoCommit(false);
            ps = SingletonConnection.getInstance().getConnection().prepareStatement("insert into t_identites (numero,identite) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, model.getNumero());
            ps.setString(2, model.getIdentite());
            ps.executeUpdate();
            ResultSet r = ps.getGeneratedKeys();
            r.next();
            long id = r.getInt(1);
            ps.close();
            // création du lien
            ps = SingletonConnection.getInstance().getConnection().prepareStatement("insert into t_link_identites_observations (ref_id_identites,ref_id_observations) VALUES (?,?)");
            ps.setLong(1, id);
            ps.setLong(2, model.getRef_id_observations());
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLIntegrityConstraintViolationException sic){
            // le couple numero, identité existe déja, on ajoute simplement une relation dans la table t_link_identites_observations
            insertLink(model);
        }

        finally {
            SingletonConnection.getInstance().getConnection().commit();
            SingletonConnection.getInstance().getConnection().setAutoCommit(true);
        }

    }

    private void insertLink(IdentiteModel model) throws SQLIntegrityConstraintViolationException,SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("select id from t_identites where numero = ? AND identite = ?");
        ps.setString(1,model.getNumero());
        ps.setString(2,model.getIdentite());
        ResultSet resultSet = ps.executeQuery();
        if(resultSet.next()){
            long id = resultSet.getLong("id");
            ps.close();
            ps = SingletonConnection.getInstance().getConnection().prepareStatement("insert into t_link_identites_observations (ref_id_identites,ref_id_observations) VALUES (?,?)");
            ps.setLong(1,id);
            ps.setLong(2,model.getRef_id_observations());
            ps.executeUpdate();
            ps.close();
        }
    }

    @Override
    public void delete(long id) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("delete from t_identites where id = ?");
        ps.setLong(1,id);
        ps.executeUpdate();
        ps.close();

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
        ps.close();

    }

    @Override
    public IdentiteModel find(long id) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("select * from t_identites INNER JOIN t_link_identites_observations where id = ? " +
                "AND t_identites.id = t_link_identites_observations.ref_id_identites");
        ps.setLong(1,id);
        ResultSet resultSet = ps.executeQuery();
        IdentiteModel model = new IdentiteModel();
        while(resultSet.next()){
            model.setId(resultSet.getLong("id"));
            model.setNumero(resultSet.getString("numero"));
            model.setIdentite(resultSet.getString("identite"));
            model.setRef_id_observations(resultSet.getLong("ref_id_observations"));

        }
        ps.close();
        return model;
    }

    public List<IdentiteModel> findNumero(String numero) throws SQLException {
        String search = "%" + numero.trim() + "%";
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("select * from t_identites INNER JOIN t_link_identites_observations where numero LIKE ? " +
                "AND t_identites.id = t_link_identites_observations.ref_id_identites");
        ps.setString(1,search);
        ResultSet resultSet = ps.executeQuery();
        List<IdentiteModel> list = new ArrayList<IdentiteModel>();
        while(resultSet.next()){
            IdentiteModel model = new IdentiteModel();
            model.setId(resultSet.getLong("id"));
            model.setNumero(resultSet.getString("numero"));
            model.setIdentite(resultSet.getString("identite"));
            model.setRef_id_observations(resultSet.getLong("ref_id_observations"));
            list.add(model);
        }
        ps.close();
        return list;
    }

    public List<IdentiteModel> findIdentite(String identite) throws SQLException {
        String search = "%" + identite.trim() + "%";
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("select * from t_identites INNER JOIN t_link_identites_observations where identite LIKE ? " +
                "AND t_identites.id = t_link_identites_observations.ref_id_identites");
        ps.setString(1,search);
        ResultSet resultSet = ps.executeQuery();
        List<IdentiteModel> list = new ArrayList<IdentiteModel>();
        while(resultSet.next()){
            IdentiteModel model = new IdentiteModel();
            model.setId(resultSet.getLong("id"));
            model.setNumero(resultSet.getString("numero"));
            model.setIdentite(resultSet.getString("identite"));
            model.setRef_id_observations(resultSet.getLong("ref_id_observations"));
            list.add(model);
        }
        ps.close();
        return list;
    }

    @Override
    public List<IdentiteModel> selectAll() throws SQLException {
        Statement st = SingletonConnection.getInstance().getConnection().createStatement();
        ResultSet resultSet  =st.executeQuery("select * from t_identites INNER JOIN t_link_identites_observations where " +
                "t_identites.id = t_link_identites_observations.ref_id_identites");
        List<IdentiteModel> list = new ArrayList<IdentiteModel>();
        while(resultSet.next()){
            IdentiteModel model = new IdentiteModel();
            model.setId(resultSet.getLong("id"));
            model.setNumero(resultSet.getString("numero"));
            model.setIdentite(resultSet.getString("identite"));
            model.setRef_id_observations(resultSet.getLong("ref_id_observations"));
            list.add(model);
        }
        st.close();
        return list;
    }

    @Override
    public List<IdentiteModel> selectFromForeignKey(long id) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("select * from t_identites INNER JOIN t_link_identites_observations WHERE " +
                "t_identites.id = t_link_identites_observations.ref_id_identites AND ref_id_observations = ?");
        ps.setLong(1,id);
        ResultSet resultSet = ps.executeQuery();
        List<IdentiteModel> list = new ArrayList<IdentiteModel>();
        while(resultSet.next()){
            IdentiteModel model = new IdentiteModel();
            model.setId(resultSet.getLong("id"));
            model.setNumero(resultSet.getString("numero"));
            model.setIdentite(resultSet.getString("identite"));
            model.setRef_id_observations(resultSet.getLong("ref_id_observations"));
            list.add(model);
        }
        ps.close();
        return list;
    }
}
