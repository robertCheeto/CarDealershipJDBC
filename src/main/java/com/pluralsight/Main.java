package com.pluralsight;

import com.pluralsight.config.DatabaseConfig;
import com.pluralsight.data.DataManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting CarDealershipDB...\n\n\n");

        DataManager dataManager = null;

        try {
            dataManager = new DataManager();

            // add Daos here

            // add homescreen display here


        } catch (Exception e) {
            System.err.println("big no no: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        } finally {
            if (dataManager != null){
                dataManager.closeConnection();
            }
            DatabaseConfig.closeDataSource();
        }
    }
}
