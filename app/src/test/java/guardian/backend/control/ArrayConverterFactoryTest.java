package guardian.backend.control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import guardian.backend.model.ArrayConverterFactory;

public class ArrayConverterFactoryTest {
    @Test
    public void canConvertFromStringArrayListToJSON() {
        ArrayList<String> oldTestArrayList = new ArrayList<String>();
        oldTestArrayList.add("test 1");
        oldTestArrayList.add("test 2");
        oldTestArrayList.add("test 3");
        String json = new ArrayConverterFactory().stringArrayToJSON(oldTestArrayList);
        ArrayList<String> newTestArrayList = new ArrayConverterFactory().jsonToStringArray(json);
        assertEquals(oldTestArrayList, newTestArrayList);
    };
    @Test
    public void canConvertFromIntegerArrayListToJSON() {
        ArrayList<Integer> oldTestArrayList = new ArrayList<Integer>();
        oldTestArrayList.add(1);
        oldTestArrayList.add(2);
        oldTestArrayList.add(3);
        String json = new ArrayConverterFactory().intArrayToJSON(oldTestArrayList);
        ArrayList<Integer> newTestArrayList = new ArrayConverterFactory().jsonToIntArray(json);
        assertEquals(oldTestArrayList, newTestArrayList);
    };
    @Test
    public void canConvertFromDateArrayListToJSON() {
        ArrayList<Date> oldTestArrayList = new ArrayList<Date>();
        oldTestArrayList.add(new Date());
        String json = new ArrayConverterFactory().dateArrayToJSON(oldTestArrayList);
        ArrayList<Date> newTestArrayList = new ArrayConverterFactory().jsonToDateArray(json);
        assertEquals(oldTestArrayList, newTestArrayList);
        
    };
}
