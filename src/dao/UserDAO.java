package dao;

import config.SingletonConnection;
import models.UserModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO<UserModel> {

    @Override
    public void insert(UserModel model) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("insert into t_users (nom,prenom,login,password,ref_id_sections) VALUES (?,?,?,?,?)");
        ps.setString(1,model.getNom());
        ps.setString(2,model.getPrenom());
        ps.setString(3,model.getLogin());
        ps.setString(4,model.getPassword());
        ps.setLong(5,model.getRef_id_sections());
        ps.executeUpdate();

    }

    @Override
    public void delete(long id) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("delete from t_users where id = ?");
        ps.executeQuery("delete from t_user where id = ?");
        ps.setLong(1,id);
        ps.executeUpdate();

    }

    @Override
    public void update(UserModel model) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("update t_users SET nom = ?," +
                "prenom = ?," +
                "login = ?," +
                "password = ? WHERE id = ?");
        ps.setString(1,model.getNom());
        ps.setString(2,model.getPrenom());
        ps.setString(3,model.getLogin());
        ps.setString(4,model.getPassword());
        ps.setLong(5,model.getId());
        ps.executeUpdate();
    }

    @Override
    public UserModel find(long id) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("select * from t_users where id = ?");
        ps.setLong(1,id);
        ResultSet resultSet = ps.executeQuery();
        UserModel model = new UserModel();
        while(resultSet.next()){
            model.setId(resultSet.getLong("id"));
            model.setNom(resultSet.getString("nom"));
            model.setPrenom(resultSet.getString("prenom"));
            model.setLogin(resultSet.getString("login"));
            model.setPassword(resultSet.getString("password"));
            model.setRef_id_sections(resultSet.getLong("ref_id_sections"));
        }
        return model;
    }

    @Override
    public List<UserModel> selectAll() throws SQLException {
        Statement st = SingletonConnection.getInstance().getConnection().createStatement();
        ResultSet resultSet  =st.executeQuery("select * from t_users");
        List<UserModel> list = new ArrayList<UserModel>();
        while(resultSet.next()){
            UserModel model = new UserModel();
            model.setId(resultSet.getLong("id"));
            model.setNom(resultSet.getString("nom"));
            model.setPrenom(resultSet.getString("prenom"));
            model.setLogin(resultSet.getString("login"));
            model.setPassword(resultSet.getString("password"));
            model.setRef_id_sections(resultSet.getLong("ref_id_sections"));
            list.add(model);
        }
        return list;
    }

    @Override
    public List<UserModel> selectFromForeignKey(long id) throws SQLException {
        PreparedStatement ps = SingletonConnection.getInstance().getConnection().prepareStatement("select * from t_users where ref_id_sections = ?");
        ps.setLong(1,id);
        ResultSet resultSet = ps.executeQuery();
        List<UserModel> list = new ArrayList<UserModel>();
        while(resultSet.next()){
            UserModel model = new UserModel();
            model.setId(resultSet.getLong("id"));
            model.setNom(resultSet.getString("nom"));
            model.setPrenom(resultSet.getString("prenom"));
            model.setLogin(resultSet.getString("login"));
            model.setPassword(resultSet.getString("password"));
            model.setRef_id_sections(resultSet.getLong("ref_id_sections"));
            list.add(model);
        }
        return list;
    }
}
