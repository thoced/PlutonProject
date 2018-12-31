package dao;

import config.SingletonConnection;
import models.SectionModel;
import models.UserModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @class class DAO pour les acces DB relatif à la section
 *
 */

public class SectionDAO extends DAO<SectionModel> {
    @Override
    public void insert(SectionModel model) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("insert into t_sections (name,comment) VALUES (?,?)");
        ps.setString(1,model.getName());
        ps.setString(2,model.getComment());
        ps.executeUpdate();

    }

    @Override
    public void delete(long id) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("delete from t_sections where id = ?");
        ps.setLong(1,id);
        ps.executeUpdate();

    }

    @Override
    public void update(SectionModel model) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("update t_sections SET name = ?," +
                "comment = ? WHERE id = ?");
        ps.setString(1,model.getName());
        ps.setString(2,model.getComment());
        ps.setLong(3,model.getId());
        ps.executeUpdate();

    }

    @Override
    public SectionModel find(long id) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("select * from t_sections where id = ?");
        ps.setLong(1,id);
        ResultSet resultSet = ps.executeQuery();
        SectionModel model = new SectionModel();
        while(resultSet.next()){
            model.setId(resultSet.getLong("id"));
            model.setName(resultSet.getString("name"));
            model.setComment(resultSet.getString("comment"));
        }
        return model;
    }

    @Override
    public List<SectionModel> selectAll() throws SQLException {
        Statement st = SingletonConnection.getInstance().getConnection().createStatement();
        ResultSet resultSet  = st.executeQuery("select * from t_sections");
        List<SectionModel> list = new ArrayList<SectionModel>();
        while(resultSet.next()){
            SectionModel model = new SectionModel();
            model.setId(resultSet.getLong("id"));
            model.setName(resultSet.getString("name"));
            model.setComment(resultSet.getString("comment"));
            list.add(model);
        }
        return list;
    }

    @Override
    public List<SectionModel> selectFromForeignKey(long id) throws SQLException {
       return null;
    }
}
