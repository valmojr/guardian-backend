package com.valmojr.guardian.model.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.valmojr.guardian.model.Patrol_AreaOfInterest;

public class Patrol_AreaOfInterestDAOTest {
    @Test
    public void canCreateAndReadInformation() {
        Patrol_AreaOfInterestDAO classUnderTest = new Patrol_AreaOfInterestDAO();
        Patrol_AreaOfInterest patrol_AreaOfInterest = new Patrol_AreaOfInterest();
        patrol_AreaOfInterest.setAssignedPatrolId(199);
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(patrol_AreaOfInterest);
        int afterCreate= classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
    }
    @Test
    public void canReadInformationById() {
        Patrol_AreaOfInterestDAO classUnderTest = new Patrol_AreaOfInterestDAO();
        assertEquals(199, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedPatrolId());
    }
    @Test
    public void canUpdateInformation() {
        Patrol_AreaOfInterestDAO classUnderTest = new Patrol_AreaOfInterestDAO();
        Patrol_AreaOfInterest patrol_AreaOfInterest = new Patrol_AreaOfInterest();
        patrol_AreaOfInterest.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        patrol_AreaOfInterest.setAssignedPatrolId(129);
        classUnderTest.update(patrol_AreaOfInterest);
        assertEquals(129, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedPatrolId());
    }
    @Test
    public void canDeleteInformation() {
        Patrol_AreaOfInterestDAO classUnderTest = new Patrol_AreaOfInterestDAO();
        int beforeDelete = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterDelete = classUnderTest.read().size();
        assertEquals(beforeDelete, afterDelete+1);
    }
}