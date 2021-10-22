package ru.absens;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import ru.absens.jsonStructure.tests.Test;
import ru.absens.jsonStructure.tests.Tests;
import ru.absens.jsonStructure.values.Value;
import ru.absens.jsonStructure.values.Values;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Task3 {

    public static void main(String[] args) {
        String testsPath = args[0];
        String valuesPath = args[1];
        String reportPath = "./report.json";
        try {
            Gson gson = new Gson();
            JsonReader testsReader = new JsonReader(new FileReader(testsPath));
            Tests tests = gson.fromJson(testsReader, Tests.class);
            JsonReader valuesReader = new JsonReader(new FileReader(valuesPath));
            Values values = gson.fromJson(valuesReader, Values.class);

            fillInAllValuesInTest(tests.tests, values.values);
            Writer reportWriter = Files.newBufferedWriter(Paths.get(reportPath));
            gson.toJson(tests, reportWriter);
            reportWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fillInAllValuesInTest(List<Test> tests, List<Value> values) {
        for (Test test : tests) {
            if (test.value == null) {
                test.value = values.stream().filter(v -> ((v.id == test.id))).findFirst().orElse(new Value()).value;
            }
            if (test.values != null) { fillInAllValuesInTest(test.values, values); }
        }
    }
}

