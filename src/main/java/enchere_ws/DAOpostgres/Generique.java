/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere_ws.DAOpostgres;

import enchere_ws.model.Produit;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tohy
 */
public class Generique {
    public void insertObject(Object object) throws Exception {
        String tableName = object.getClass().getSimpleName();
        StringBuilder columns = new StringBuilder();
        StringBuilder values = new StringBuilder();
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if(!field.getName().equalsIgnoreCase("id")) {
                columns.append(field.getName()).append(",");
                values.append("'").append(field.get(object)).append("',");
            }
        }
        columns.deleteCharAt(columns.length() - 1);
        values.deleteCharAt(values.length() - 1);
        String sql = "INSERT INTO " + tableName + "(" + columns + ") VALUES(" + values + ")";
        System.out.println(sql);
        Connection connection = new Connexion().SeConnecter();
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        connection.close();
    }

    public List<Object> selectObjectss(Class clazz) throws SQLException, InstantiationException, IllegalAccessException {
        List<Object> objects = new ArrayList<>();
        String tableName = clazz.getSimpleName();
        String sql = "SELECT * FROM " + tableName;
        Connection connection = new Connexion().SeConnecter();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Object object = clazz.newInstance();
            for (Field field : object.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                field.set(object, resultSet.getObject(field.getName()));
            }
            objects.add(object);
        }
        connection.close();
        return objects;
    }

    public List<Object> selectObjectsCond(Class clazz, String col, String value) throws SQLException, InstantiationException, IllegalAccessException {
        List<Object> objects = new ArrayList<>();
        String tableName = clazz.getSimpleName();
        String sql = "SELECT * FROM " + tableName+" WHERE "+col+" = "+value;
        System.out.println(sql);
        Connection connection = new Connexion().SeConnecter();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Object object = clazz.newInstance();
            for (Field field : object.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                field.set(object, resultSet.getObject(field.getName()));
            }
            objects.add(object);
        }
        connection.close();
        return objects;
    }

    public List<Object> selectObjects(Class clazz, String req) throws SQLException, InstantiationException, IllegalAccessException {
        List<Object> objects = new ArrayList<>();
        String tableName = clazz.getSimpleName();
        String sql = req;
        System.out.println(sql);
        Connection connection = new Connexion().SeConnecter();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Object object = clazz.newInstance();
            for (Field field : object.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                field.set(object, resultSet.getObject(field.getName()));
            }
            objects.add(object);
        }
        connection.close();
        return objects;
    }
    public void insertProduit(Produit newProduit) throws Exception {
        String sql = "INSERT INTO produit(idclient,nomproduit,idcategorie,dureeenchereminute,prixmin)values (" + newProduit.getIdclient() + ",'" +newProduit.getNomproduit() + "'," +newProduit.getIdcategorie()+",'" +newProduit.getDureeenchereminute()+"',"+newProduit.getPrixmin()+ ")";
        System.out.println(sql);
        Connection connection = new Connexion().SeConnecter();
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        connection.close();
    }
    /*public void insertImage(Produit newProduit) throws Exception {
        String sql = "INSERT INTO images (image_data) VALUES ("+  +")";
        System.out.println(sql);
        Connection connection = new Connexion().SeConnecter();
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        connection.close();
    }*/



}
