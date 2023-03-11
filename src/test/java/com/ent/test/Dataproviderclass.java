package com.ent.test;

import com.ent.utils.DataReader;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Dataproviderclass {
    @DataProvider(name = "one")
    public static Object[][] OppLOcNavigation() throws IOException {
        DataReader datareader = new DataReader();
        // System.out.println( datareader.com.ent.test.ExcelTest("Data/TestData.xlsx","Login"));
        List<Map<String, String>> maze = datareader.ExcelTest("Data/Login.xlsx", "login");
        // Rows - Number of times your test has to be repeated.
        // Columns - Number of parameters in test data.
        Object[][] logindetails = new Object[maze.size()][1];
        int i = 0;
        for (Map<String, String> mmap : maze) {
            logindetails[i][0] = mmap;
            i++;
        }

        return logindetails;
    }
}

