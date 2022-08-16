package guardian.backend.model;

import java.util.Date;
import java.util.ArrayList;

import com.google.gson.Gson;

public class ArrayConverter {
    public String intArrayToJSON(ArrayList<Integer> arrayList) {
        return new Gson().toJson(arrayList);
    }
    public String stringArrayToJSON(ArrayList<String> arrayList) {
        return new Gson().toJson(arrayList);
    }
    public String dateArrayToJSON(ArrayList<Date> arrayList) {
        return new Gson().toJson(arrayList);
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
        return new Gson().fromJson(json, ArrayList.class);
    }
}
