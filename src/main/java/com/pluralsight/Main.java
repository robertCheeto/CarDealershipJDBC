package com.pluralsight;

import com.pluralsight.config.DatabaseConfig;
import com.pluralsight.data.DataManager;
import com.pluralsight.data.VehicleDao;
import com.pluralsight.ui.HomeScreen;
import com.pluralsight.ui.VehicleSearch;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting CarDealershipDB...\n\n\n");

        DataManager dataManager = null;

        try {
            dataManager = new DataManager();

            VehicleDao vehicleDao = new VehicleDao(dataManager);

            VehicleSearch vehicleSearch = new VehicleSearch(vehicleDao);

            HomeScreen homeScreen = new HomeScreen(vehicleSearch);

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
