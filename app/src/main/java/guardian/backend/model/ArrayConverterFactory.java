package guardian.backend.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.google.gson.Gson;

public class ArrayConverterFactory {
    public String intArrayToJSON(ArrayList<Integer> arrayList) {
        return new Gson().toJson(arrayList);
    }
    public String stringArrayToJSON(ArrayList<String> arrayList) {
        return new Gson().toJson(arrayList);
    }
    public String LocalDateTimeArrayToJSON(ArrayList<LocalDateTime> arrayList) {
        ArrayList<ArrayList<Integer>> dateShelf = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < arrayList.size(); i++) {
            ArrayList<Integer> newDateInInteger = new ArrayList<Integer>();
            newDateInInteger.add(arrayList.get(i).getYear());
            newDateInInteger.add(arrayList.get(i).getMonthValue());
            newDateInInteger.add(arrayList.get(i).getDayOfMonth());
            newDateInInteger.add(arrayList.get(i).getHour());
            newDateInInteger.add(arrayList.get(i).getMinute());
            newDateInInteger.add(arrayList.get(i).getSecond());
            newDateInInteger.add(arrayList.get(i).getNano());
            dateShelf.add(newDateInInteger);
        }
        String json = new Gson().toJson(dateShelf);
        return json;
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
    public ArrayList<LocalDateTime> jsonToLocalDateTimeArray(String json) {
        ArrayList<ArrayList<Double>> newDateShelfInDouble = new Gson().fromJson(json, ArrayList.class);
        ArrayList<ArrayList<Integer>> newDateShelfInInteger = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < newDateShelfInDouble.size(); i++) {
            ArrayList<Integer> newDateInInteger = new ArrayList<Integer>();
            for (int j = 0; j < newDateShelfInDouble.get(i).size(); j++) {
                newDateInInteger.add((int) Math.round(newDateShelfInDouble.get(i).get(j)));
            }
            newDateShelfInInteger.add(newDateInInteger);
        }
        ArrayList<LocalDateTime> newLocalDateTimeArrayList = new ArrayList<LocalDateTime>();
        for (int i = 0; i < newDateShelfInInteger.size(); i++) {
            LocalDateTime newDate = LocalDateTime.of(newDateShelfInInteger.get(i).get(0), newDateShelfInInteger.get(i).get(1), newDateShelfInInteger.get(i).get(2), newDateShelfInInteger.get(i).get(3), newDateShelfInInteger.get(i).get(4), newDateShelfInInteger.get(i).get(5), newDateShelfInInteger.get(i).get(6));
            newLocalDateTimeArrayList.add(newDate);
        }
        return newLocalDateTimeArrayList;
    }
}