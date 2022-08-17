package guardian.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

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
        ArrayList<LocalDateTime> oldTestArrayList = new ArrayList<LocalDateTime>();
        oldTestArrayList.add(LocalDateTime.now());
        String json = new ArrayConverterFactory().LocalDateTimeArrayToJSON(oldTestArrayList);
        ArrayList<LocalDateTime> newTestArrayList = new ArrayConverterFactory().jsonToLocalDateTimeArray(json);
        assertEquals(oldTestArrayList, newTestArrayList);
    };
}
