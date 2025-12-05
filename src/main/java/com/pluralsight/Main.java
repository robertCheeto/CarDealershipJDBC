package com.pluralsight;

import com.pluralsight.config.DatabaseConfig;
import com.pluralsight.data.DataManager;
import com.pluralsight.data.VehicleDao;
import com.pluralsight.ui.HomeScreen;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting CarDealershipDB...\n\n\n");

        DataManager dataManager = null;

        try {
            dataManager = new DataManager();

            VehicleDao vehicleDao = new VehicleDao(dataManager);
            // add Daos here

            HomeScreen homeScreen = new HomeScreen();

            homeScreen.displayHomeScreen();


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
