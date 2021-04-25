package ioServices;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import coreUtils.CoreFileUtils;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import java.io.*;
import java.util.*;


public class FileServices {

    public void writeJsonFile(String fileContent,String filePath){
        try{
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(fileContent);
            fileWriter.flush();
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public JSONObject readJsonFile(String filePath){
        JSONObject jsonFile = new JSONObject();
        try {
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            jsonFile = (JSONObject) jsonParser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonFile;
    }

    public String readPropertiesFile(String filePath){
        String file = "";
        try {
            FileReader reader = new FileReader(filePath);
            Properties p = new Properties();
            p.load(reader);
            file = p.getProperty("Set-Cookie");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    public void clearFile(String filePath){
        try{
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  List<List<String>> readCSVFile(String filePath){
        List<List<String>> list1 = new ArrayList<>();
        try{
            CSVReader csvReader = new CSVReader(new FileReader(filePath));
            List<String[]> cSVData = csvReader.readAll();

            System.out.println("To get The Value of individual Row" );



            for  (int j = 0 ; j <cSVData.size() ; j++) {
                List<String> stringList = new ArrayList<>();
                for (int i = 0; i < cSVData.get(j).length; i++) {
                    stringList.add(cSVData.get(j)[i]);
                }
                list1.add(stringList);
            }

        }catch (Exception e){
            System.out.println("Exception At Reading CSV File " + e);
        }return  list1;
    }



    public void writeCSVFile( List<String> header , List<String> value    , String filePath) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(filePath, false ));
            //  String [] record = "3,David,Feezor,USA,40".split(",");
            String headerValue[] = new String[header.size()];
            for (int i = 0 ; i < header.size() ; i ++){
                headerValue[i] = header.get(i);
            }
            writer.writeNext(headerValue);
            String keyValue[] = new String[value.size()];
            for (int i = 0 ; i < value.size() ; i ++){
                keyValue[i] = value.get(i);
            }
            writer.writeNext(keyValue);
            writer.close();
        }catch (Exception e){
            System.out.println("Exception At CSV File Writer"+e);
        }
    }


}
