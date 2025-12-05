package com.pluralsight.ui;

import com.pluralsight.data.DataManager;
import com.pluralsight.data.DatabaseDao;

public class DataBaseSeach {

    private final DatabaseDao databaseDao;

    public DatabaseDao(DataManager dataManager){
        this.dataManager = dataManager;
    }


}
