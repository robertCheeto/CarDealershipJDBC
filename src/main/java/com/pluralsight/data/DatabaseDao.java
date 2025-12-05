package com.pluralsight.data;

import com.pluralsight.models.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseDao {

    private final DataManager dataManager;

    public DatabaseDao(DataManager dataManager){
        this.dataManager = dataManager;
    }
}
