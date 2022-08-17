package guardian.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import guardian.backend.control.AreaOfInterest;


public class AreaOfInterestDAOTest {
    @Test
    public void canCreateAndReadAreaOfInterests() {
        AreaOfInterest areaOfInterest = new AreaOfInterest();
        areaOfInterest.setDescription("this Area Of Interest was just created!");
        AreaOfInterestDAO classUnderTest = new AreaOfInterestDAO();
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(areaOfInterest);
        int afterCreate = classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
    };
    @Test
    public void canUpdateAreaOfInterests() {
        String description = "this Area Of Interest was just updated!";
        AreaOfInterest AreaOfInterest = new AreaOfInterest();
        AreaOfInterestDAO classUnderTest = new AreaOfInterestDAO();
        AreaOfInterest.setDescription(description);
        AreaOfInterest.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        classUnderTest.update(AreaOfInterest);
        assertEquals(classUnderTest.read().get(classUnderTest.read().size()-1).getDescription(), description);
    };
    @Test
    public void canDeleteAreaOfInterests() {
        AreaOfInterestDAO classUnderTest = new AreaOfInterestDAO();
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterCreate = classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate+1);
    };
}
