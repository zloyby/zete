package by.zloy.apps.csv.passconv;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import by.zloy.apps.csv.CvsChanger;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class PassConvert {
    public static void main(String[] args) throws IOException {
        PassConvert passConvert = new PassConvert();
        passConvert.convert();
    }

    private void convert() throws IOException {
        CSVReader reader = new CSVReader(new FileReader("/Users/eugene/Documents/PWDS/lp-exp.csv"));

        ColumnPositionMappingStrategy<LP> mapping = new ColumnPositionMappingStrategy<>();
        mapping.setType(LP.class);
        String[] columns = new String[]{
                "url", "username", "password", "extra", "name", "grouping", "fav"
        };
        mapping.setColumnMapping(columns);

        CsvToBean<LP> csvColumn= new CsvToBean<>();
        final List<LP> lps = csvColumn.parse(mapping, reader);

        File nc = new File("/Users/eugene/Documents/PWDS/kp-NEW.csv");
        CvsChanger.MyCSVWriter writer = new CvsChanger.MyCSVWriter(new FileWriter(nc), ',', CSVWriter.DEFAULT_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER);
        for (LP lp : lps) {
            KP kp = new KP();
            kp.setGroup("Root/" + (Objects.isNull(lp.getGrouping()) ? "unsorted" : lp.getGrouping()));
            kp.setTitle(lp.getName());
            kp.setUsername(lp.getUsername());
            kp.setPassword(lp.getPassword());
            kp.setURL(lp.getUrl());
            kp.setNotes(lp.getExtra());
            writer.writeNext(kp.getAll());
        }
        writer.close();
    }

}
