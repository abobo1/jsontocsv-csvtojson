package edu.jsu.mcis;

import au.com.bytecode.opencsv.CSVParser;
import static edu.jsu.mcis.Main.json;
import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ConverterTest {
    
    private String csvString;
    private String jsonString;

    @Before
    public void setUp() 
    {
        Main.runConversions();
    }
     @SuppressWarnings("unchecked")
    @Test
    public void testConvertCSVtoJSON() {
        JSONObject jsonTest = new JSONObject();
        
        JSONArray row1 = new JSONArray();
        JSONArray row2 = new JSONArray();
        JSONArray row3 = new JSONArray();
        JSONArray row4 = new JSONArray();
        JSONArray row5 = new JSONArray();
        JSONArray row6 = new JSONArray();
        JSONArray row7 = new JSONArray();
        JSONArray row8 = new JSONArray();

        JSONArray data = new JSONArray();
        
        JSONArray colHeaders = new JSONArray();
        JSONArray rowHeaders = new JSONArray();
        
        colHeaders.add("Total");
        colHeaders.add("Assignment 1");
        colHeaders.add("Assignment 2");
        colHeaders.add("Exam 1");
       
        rowHeaders.add("111278");
        rowHeaders.add("111352");
        rowHeaders.add("111373");
        rowHeaders.add("111305");
        rowHeaders.add("111399");
        rowHeaders.add("111160");
        rowHeaders.add("111276");
        rowHeaders.add("111241");
        
        row1.add(611);row1.add(146);row1.add(128);row1.add(337);
        row2.add(867);row2.add(227);row2.add(228);row2.add(412);
        row3.add(461);row3.add(96);row3.add(90);row3.add(275);
        row4.add(835);row4.add(220);row4.add(217);row4.add(398);
        row5.add(898);row5.add(226);row5.add(229);row5.add(443);
        row6.add(454);row6.add(77);row6.add(125);row6.add(252);
        row7.add(579);row7.add(130);row7.add(111);row7.add(338);
        row8.add(973);row8.add(236);row8.add(237);row8.add(500);
        
        data.add(row1);
        data.add(row2);
        data.add(row3);
        data.add(row4);
        data.add(row5);
        data.add(row6);
        data.add(row7);
        data.add(row8);
        
        

        jsonTest.put("colHeaders", colHeaders);
        jsonTest.put("rowHeaders", rowHeaders);
        jsonTest.put("data", data);
        
        assertEquals(jsonTest.toString(),Main.json);

    }

    @Test
    public void testConvertJSONtoCSV() {
           String csvTest="\"ID\",\"Total\",\"Assignment 1\",\"Assignment 2\",\"Exam 1\"\n" +
                        "\"111278\",\"611\",\"146\",\"128\",\"337\"\n" +
                        "\"111352\",\"867\",\"227\",\"228\",\"412\"\n" +
                        "\"111373\",\"461\",\"96\",\"90\",\"275\"\n" +
                        "\"111305\",\"835\",\"220\",\"217\",\"398\"\n" +
                        "\"111399\",\"898\",\"226\",\"229\",\"443\"\n" +
                        "\"111160\",\"454\",\"77\",\"125\",\"252\"\n" +
                        "\"111276\",\"579\",\"130\",\"111\",\"338\"\n" +
                        "\"111241\",\"973\",\"236\",\"237\",\"500\"\n" 
                        ;
        
        assertEquals(csvTest, Main.csv);
        
    }
}







