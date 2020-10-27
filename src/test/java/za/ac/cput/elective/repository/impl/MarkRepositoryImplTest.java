//package za.ac.cput.elective.repository.impl;
//
///**
// * @author @Wasiem Cassiem
// * Desc: Testing the mark repository here
// * Date: 2020/08/29
// **/
//
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import za.ac.cput.elective.entity.Mark;
//import za.ac.cput.elective.factory.MarkFactory;
//import za.ac.cput.elective.repository.MarkRepository;
//
//import static org.junit.Assert.*;
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//
//public class MarkRepositoryImplTest
//{
//    @Autowired
//    private static MarkRepository repository;
//    private static Mark mark = MarkFactory.createMark("001");
//
//    @Test
//    public void getRepository() {
//    }
//
//    @Test
//    public void a_create() {
//        Mark created = repository.create(mark);
//        Assert.assertEquals(mark.getMarksID(), created.getMarksID());
//        System.out.println("Created: " + created);
//    }
//
//    @Test
//    public void b_read() {
//        Mark read = repository.read(mark.getMarksID());
//        System.out.println("Read: " + read);
//    }
//
//    @Test
//    public void c_update() {
//        Mark updated = new Mark.Builder().copy(mark).setMarksID("001").build();
//        updated = repository.update(updated);
//        System.out.println("Updated: " + updated);
//    }
//
//    @Test
//    public void e_delete() {
//        boolean deleted = repository.delete(mark.getMarksID());
//        Assert.assertTrue(deleted);
//    }
//
//    @Test
//    public void m_getAll() {
//        System.out.println("Get all: " + repository.findAll());
//    }
//}