package com.nure.prykhodko.dao.impl;

import static com.nure.prykhodko.constants.ApplicationConstants.EMAIL;
import static com.nure.prykhodko.constants.ApplicationConstants.ID;
import static com.nure.prykhodko.constants.ApplicationConstants.LOGIN;
import static com.nure.prykhodko.constants.ApplicationConstants.NAME;
import static com.nure.prykhodko.constants.ApplicationConstants.PASSWORD;
import static com.nure.prykhodko.constants.ApplicationConstants.SURNAME;
import static com.nure.prykhodko.constants.DBConstants.ADD_USER;
import static com.nure.prykhodko.constants.DBConstants.DELETE_USER_BY_LOGIN;
import static com.nure.prykhodko.constants.DBConstants.GET_ALL_USERS;
import static com.nure.prykhodko.constants.DBConstants.GET_USER_BY_ID;
import static com.nure.prykhodko.constants.DBConstants.GET_USER_BY_LOGIN;
import static com.nure.prykhodko.constants.LoggerMessagesConstants.ERR_CANNOT_ADD_USER;
import static com.nure.prykhodko.constants.LoggerMessagesConstants.ERR_CANNOT_DELETE_USER_BY_LOGIN;
import static com.nure.prykhodko.constants.LoggerMessagesConstants.ERR_CANNOT_GET_ALL_USERS;
import static com.nure.prykhodko.constants.LoggerMessagesConstants.ERR_CANNOT_GET_USER_BY_ID;
import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ONE;
import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;

import com.nure.prykhodko.dao.UserDAO;
import com.nure.prykhodko.entity.User;
import com.nure.prykhodko.entity.UserRole;
import com.nure.prykhodko.handler.ConnectionHolder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class UserDAOImpl implements UserDAO {

    private static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

    @Override
    public User get(int id) {
        try (PreparedStatement pstm = ConnectionHolder.getConnection().prepareStatement(GET_USER_BY_ID);
            ResultSet resultSet = pstm.executeQuery()) {
            pstm.setInt(1, id);

            if (resultSet.next()) {
                return parseResultSetToUser(resultSet);
            }
        } catch (SQLException e) {
            LOGGER.error(ERR_CANNOT_GET_USER_BY_ID);
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();

        try (PreparedStatement preparedStatement = ConnectionHolder.getConnection().prepareStatement(GET_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                users.add(parseResultSetToUser(resultSet));
            }

            return users;
        } catch (SQLException ex) {
            LOGGER.error(ERR_CANNOT_GET_ALL_USERS);
        }
        return users;
    }

    @Override
    public User add(User user) {
        PreparedStatement pstmt = null;

        try {
            pstmt = ConnectionHolder.getConnection().prepareStatement(ADD_USER);
            fillPreparedStatementByUserData(pstmt, user);

            if (pstmt.executeUpdate() > INTEGER_ZERO) {
                return user;
            }
        } catch (SQLException ex) {
            LOGGER.error(ERR_CANNOT_ADD_USER);
        }
        return null;
    }

    @Override
    public boolean delete(User user) {
        try (PreparedStatement preparedStatement = ConnectionHolder.getConnection().prepareStatement(DELETE_USER_BY_LOGIN);) {
            preparedStatement.setString(INTEGER_ONE, user.getLogin());

            if (preparedStatement.executeUpdate() > INTEGER_ZERO) {
                return true;
            }
        } catch (SQLException ex) {
            LOGGER.error(ERR_CANNOT_DELETE_USER_BY_LOGIN);
        }
        return false;
    }

    @Override
    public User getByLogin(String login) {
        try (PreparedStatement preparedStatement = ConnectionHolder.getConnection().prepareStatement(GET_USER_BY_LOGIN)) {
            preparedStatement.setString(INTEGER_ONE, login);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return parseResultSetToUser(resultSet);
            }
        } catch (SQLException ex) {
            LOGGER.error(ERR_CANNOT_DELETE_USER_BY_LOGIN);
        }
        return null;
    }

    private void fillPreparedStatementByUserData(PreparedStatement pstmt, User user) throws SQLException {
        int i = 0;
        pstmt.setString(++i, user.getName());
        pstmt.setString(++i, user.getSurname());
        pstmt.setString(++i, user.getLogin());
        pstmt.setString(++i, user.getEmail());
        pstmt.setString(++i, user.getPassword());
        pstmt.setInt(++i, INTEGER_ONE);
    }

    private User parseResultSetToUser(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(ID);
        String name = resultSet.getString(NAME);
        String surName = resultSet.getString(SURNAME);
        String login = resultSet.getString(LOGIN);
        String email = resultSet.getString(EMAIL);
        String password = resultSet.getString(PASSWORD);
        UserRole roleId = UserRole.valueOf(resultSet.getString("role").toUpperCase());
        return new User(id, name, surName, email, login, password, roleId);
    }
}
