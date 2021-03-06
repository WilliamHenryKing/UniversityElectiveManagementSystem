//package za.ac.cput.elective.repository.impl;
//
///**
// * @author: Ridhaa Hendricks 218120966, GitHub: ridhaahendricks
// * Desc: Create class for FacultyRepositoryImplTest which will test all the methods
//         within the FacultyRepositoryImpl to ensure correct outcomes.
// * Date: 30 August 2020
// **/
//
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import za.ac.cput.elective.entity.Faculty;
//import za.ac.cput.elective.factory.FacultyFactory;
//import za.ac.cput.elective.repository.FacultyRepository;
//
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class FacultyRepositoryImplTest {
//
//    @Autowired
//    private FacultyRepository facuRepo;
//    private static Faculty facu = FacultyFactory.addFaculty("1234", "Engineeeering");
//
//    @Test
//    public void a_create() {
//        Faculty added = facuRepo.save(facu);
//        Assert.assertEquals(facu.getFacultyID(), added.getFacultyID());
//        System.out.println("Added: " + added);
//    }
//
//    @Test
//    public void b_read() {
//        Faculty found = facuRepo.read(facu.getFacultyID());
//        System.out.println("Faculty ID: " + found.getFacultyID() + ", Faculty Name: " + found.getFacultyName());
//    }
//
//    @Test
//    public void c_update() {
//        Faculty changed = new Faculty.Builder().copy(facu).setFacultyName("Engineering").build();
//        changed = facuRepo.update(changed);
//        System.out.println("Changed: " + changed);
//    }
//
//    @Test
//    public void e_delete() {
//        boolean removed = facuRepo.delete(facu.getFacultyID());
//        Assert.assertTrue(removed);
//        if (removed = true ){
//            System.out.println("Removed? Yes");
//        } else {
//            System.out.println("Removed? No");
//        }
//    }
//
//    @Test
//    public void d_getAll() {
//        System.out.println("Display All: " + facuRepo.findAll());
//    }
//}