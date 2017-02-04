package edu.jsu.mcis;

import java.io.*;
import java.util.*;
import au.com.bytecode.opencsv.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Converter 
{
   

    
    @SuppressWarnings("unchecked")
    public static String csvToJson(String csvString) 
{

        
        JSONObject json = new JSONObject();
       
        JSONArray data = new JSONArray();
        JSONArray colHeaders = new JSONArray();
        JSONArray rowHeaders = new JSONArray();
        
        colHeaders.add("Total");
        colHeaders.add("Assignment 1");
        colHeaders.add("Assignment 2");
        colHeaders.add("Exam 1");

        json.put("colHeaders", colHeaders);
        json.put("rowHeaders", rowHeaders);
        json.put("data", data);


        CSVParser parser = new CSVParser();
        BufferedReader reader = new BufferedReader(new StringReader(csvString));
        

        try 
        {

            String line = reader.readLine();

            while ((line = reader.readLine()) != null)
             {

                String[] record = parser.parseLine(line);
                rowHeaders.add(record[0]);
                JSONArray row = new JSONArray();
                row.add(new Long(record[1]));
                row.add(new Long(record[2]));
                row.add(new Long(record[3]));
                row.add(new Long(record[4]));
                data.add(row);
          }
            
        } catch (IOException e) {
        }
        
        return json.toString();

    }
  
    public static String jsonToCsv(String jsonString) 
    {
        JSONObject json = null;

        try 
        {
            JSONParser jParser = new JSONParser();
            json = (JSONObject) jParser.parse(jsonString);
        } 
        
        catch (Exception e) {}
            

        
        
        
       String csvString = "\"ID\"," + Converter.<String>joinArray((JSONArray) json.get("colHeaders")) + "\n";

       JSONArray rowHeaders = (JSONArray) json.get("rowHeaders");
       JSONArray data = (JSONArray) json.get("data");
       
       
            

    for (int i = 0; i < rowHeaders.size(); i++)
        {
           
            csvString += ( "\""+ (String) rowHeaders.get(i) + "\"," + Converter.<Long>joinArray((JSONArray) data.get(i)) + "\n");
       
        }

        
        return csvString;
    }


     @SuppressWarnings("unchecked")

     
    private static <T> String joinArray(JSONArray jsarray)
    {
        
        String lineByLine = "";
        
        for (int i = 0; i < jsarray.size(); i++)
     {
           
            lineByLine = (lineByLine + "\"" + ((T) jsarray.get(i)) + "\"");
                if (i < jsarray.size() - 1) 
              
                {
               
                lineByLine = lineByLine + ",";

               }
        }
        return lineByLine;
    }
}















