package dataParcer;

import com.google.gson.Gson;
import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

public final class CSVParser {

    public static Object[][] getDataForDataProvider(String path, Class className) {
        List<HashMap<String, Object>> hashList = getHashListForDataPath(path);
        List<Object> ob = getRequestBodyFromData(hashList, className);
        final Object[][] dataProvider = new Object[ob.size()][1];
        int i = 0;
        for (Object k : ob) {
            Gson gson = new Gson();
            dataProvider[i][0] = gson.toJson(k);
            i++;
//            System.out.println("getDataForDataProvider : " + gson.toJson(k));
        }
        return dataProvider;
    }

    public static List<Object> getRequestBodyFromData(List<HashMap<String, Object>> data, Class t) {
        try {
            List<Object> requestPojos = new ArrayList<Object>();
            for (HashMap<String, Object> row : data) {
                Object requestPojo = recursionmethod(row, t);
                requestPojos.add(requestPojo);
            }
            return requestPojos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



    private static Object recursionmethod(HashMap<String, Object> data, Class t) {
        try {
            //takes the default constructor for specified class
            Object request = t.getConstructor().newInstance();
//            System.out.println(request.toString());
            for (Field field : t.getFields()) {
//                System.out.println(field.getType().toString().toLowerCase());
                if ((field.getType().toString()).toLowerCase().contains("models")) {
                    Class nc = field.getType();
                    //System.out.println(nc.getName());
                    Object newRequestObject = recursionmethod(data, nc);
                    field.set(request, newRequestObject);
                } else {
                    Object value = data.get(field.getName());
                    field.set(request, value);
                }
            }
            return request;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            System.out.println(e.toString());
        }
        return null;
    }



    public static List<HashMap<String, Object>> getHashListForDataPath(String path) {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(path));
            String[] line;
            int i = 1;
            String[] keys = {};
            List<HashMap<String, Object>> hashList = new ArrayList<>();
            while ((line = reader.readNext()) != null) {
                if (i == 1) {
                    keys = new String[line.length];
                    for (int l = 0; l < line.length; l++) {
                        keys[l] = line[l];
                    }
                    i++;
                } else {
                    HashMap<String, Object> map = new HashMap<>();
                    for (int l = 0; l < line.length; l++) {
                        map.put(keys[l], line[l]);
                    }
                    hashList.add(map);
                }
            }
            return hashList;
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return null;
    }
}