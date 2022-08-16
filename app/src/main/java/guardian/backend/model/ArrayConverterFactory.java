package guardian.backend.model;

import java.util.Date;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ArrayConverterFactory {
    public String intArrayToJSON(ArrayList<Integer> arrayList) {
        return new Gson().toJson(arrayList);
    }
    public String stringArrayToJSON(ArrayList<String> arrayList) {
        return new Gson().toJson(arrayList);
    }
    public String dateArrayToJSON(ArrayList<Date> arrayList) {
        ArrayList<Long> longConverter = new ArrayList<Long>();
        for (int i = 0; i < arrayList.size(); i++) {
            longConverter.add(arrayList.get(i).getTime());
        }
        return new Gson().toJson(longConverter);
    }
    public ArrayList<Integer> jsonToIntArray(String json) {
        ArrayList<Double> extractedArray = new Gson().fromJson(json, ArrayList.class);
        ArrayList<Integer> manipuledArray = new ArrayList<Integer>();
        for (int i = 0; i < extractedArray.size(); i++) {
            manipuledArray.add((int) Math.round(extractedArray.get(i)));
        }
        return manipuledArray;
    }
    public ArrayList<String> jsonToStringArray(String json) {
        return new Gson().fromJson(json, ArrayList.class);
    }
    public ArrayList<Date> jsonToDateArray(String json) {
        ArrayList<Date> newArrayList = new ArrayList<Date>();
        ArrayList<Double> manipuledArray = new Gson().fromJson(json, ArrayList.class);
        ArrayList<Integer> extractedArray = new ArrayList<>();
        for (int i = 0; i < manipuledArray.size(); i++) {
            extractedArray.add((int) Math.round(manipuledArray.get(i)));
        }
        for (int i = 0; i < extractedArray.size(); i++) {
            Date newDate = new Date();
            long time = extractedArray.get(i);
            newDate.setTime(time);
            newArrayList.add(newDate);
        }
        return newArrayList;
    }
}
