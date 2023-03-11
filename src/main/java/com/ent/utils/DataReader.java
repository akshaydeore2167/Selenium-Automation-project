package com.ent.utils;



import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kirtesh.mehta on 7/3/2017.
 */
public class DataReader {


    public List<Map<String, String>> ExcelTest(String Path, String SheetName) throws IOException {
        List<Map<String, String>> list = new ArrayList();
        ExcelReader excelobject = new ExcelReader(Path);

        for (int i = 1; i < excelobject.getRowCount(SheetName); i++) {
            Map<String, String> mMap = new LinkedHashMap<>();
            for (int j = 0; j < excelobject.getColumnCount(SheetName, i); j++) {
                mMap.put(excelobject.getCellStringData(SheetName, 0, j), excelobject.getCellStringData(SheetName, i, j));
            }

            list.add(mMap);
        }
        return list;
    }
    public List<Map<String, String>> getdata(String Path, String SheetName) throws IOException {
        List<Map<String, String>> list = new ArrayList();
        ExcelReader excelobject = new ExcelReader(Path);

        for (int i = 1; i < excelobject.getRowCount(SheetName); i++) {
            Map<String, String> mMap = new LinkedHashMap<>();
            for (int j = 0; j < excelobject.getColumnCount(SheetName, i); j++) {
                if (excelobject.getCellStringData(SheetName, i, j).contains("|")){
                    String s[] = excelobject.getCellStringData(SheetName, i, j).split(":");
                    for ( int k = 0; k<=s.length;k++)

                    {
                        System.out.println("The Split values are +"+ s[k]);
                        mMap.put(excelobject.getCellStringData(SheetName, 0, j), s[k]);
                    }

                }else{
                    mMap.put(excelobject.getCellStringData(SheetName, 0, j), excelobject.getCellStringData(SheetName, i, j));

                }

            }

            list.add(mMap);
        }
        System.out.println("++++++++++++++++++++++++++++++"+list+"++++++++++++++++++++++++++++++");
        return list;
    }

    public List<Map<String, String>> filterdata(String Path, String SheetName, int colnum) throws IOException {
        List<Map<String, String>> list = new ArrayList();
        ExcelReader excelobject = new ExcelReader(Path);
        Map<String, String> mMap = new LinkedHashMap<>();

        mMap.put(excelobject.getCellStringData(SheetName, 0, colnum), excelobject.getCellStringData(SheetName, 1, colnum));
        System.out.println(mMap);

        list.add(mMap);

        return list;
    }



}



