package dao;

import config.SingletonConnection;
import models.DossierModel;
import models.SectionModel;
import models.UserModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @class class DAO pour les acces DB relatif aux dossiers
 * @author thonon cedric
 */

public class DossierDAO extends DAO<DossierModel> {

    @Override
    public void insert(DossierModel model) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("insert into t_dossiers (name,comment,ref_id_sections) VALUES (?,?,?)");
        ps.setString(1,model.getName());
        ps.setString(2,model.getComment());
        ps.setLong(3,model.getRef_id_sections());
        ps.executeUpdate();
        ps.close();

    }

    @Override
    public void delete(long id) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("delete from t_dossiers where id = ?");
        ps.setLong(1,id);
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void update(DossierModel model) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("update t_dossiers SET name = ?," +
                "comment = ?, " +
                "ref_id_sections = ? WHERE id = ?");
        ps.setString(1,model.getName());
        ps.setString(2,model.getComment());
        ps.setLong(3,model.getRef_id_sections());
        ps.setLong(4,model.getId());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public DossierModel find(long id) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("select * from t_dossiers where id = ?");
        ps.setLong(1,id);
        ResultSet resultSet = ps.executeQuery();
        DossierModel model = new DossierModel();
        while(resultSet.next()){
            model.setId(resultSet.getLong("id"));
            model.setName(resultSet.getString("name"));
            model.setComment(resultSet.getString("comment"));
            model.setRef_id_sections(resultSet.getLong("ref_id_sections"));
        }
        ps.close();
        return model;
    }

    @Override
    public List<DossierModel> selectAll() throws SQLException {
        Statement st = SingletonConnection.getInstance().getConnection().createStatement();
        ResultSet resultSet  = st.executeQuery("select * from t_dossiers");
        List<DossierModel> list = new ArrayList<DossierModel>();
        while(resultSet.next()){
            DossierModel model = new DossierModel();
            model.setId(resultSet.getLong("id"));
            model.setName(resultSet.getString("name"));
            model.setComment(resultSet.getString("comment"));
            model.setRef_id_sections(resultSet.getLong("ref_id_sections"));
            list.add(model);
        }
        st.close();
        return list;
    }

    @Override
    public List<DossierModel> selectFromForeignKey(long id) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("select * from t_dossiers where ref_id_sections = ?");
        ps.setLong(1,id);
        ResultSet resultSet = ps.executeQuery();
        List<DossierModel> list = new ArrayList<DossierModel>();
        while(resultSet.next()){
            DossierModel model = new DossierModel();
            model.setId(resultSet.getLong("id"));
            model.setName(resultSet.getString("name"));
            model.setComment(resultSet.getString("comment"));
            model.setRef_id_sections(resultSet.getLong("ref_id_sections"));
            list.add(model);
        }
        ps.close();
        return list;
    }
}
