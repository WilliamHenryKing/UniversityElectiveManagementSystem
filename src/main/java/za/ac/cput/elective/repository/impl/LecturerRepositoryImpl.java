//package za.ac.cput.elective.repository.impl;
//
//import za.ac.cput.elective.entity.Lecturer;
//import za.ac.cput.elective.repository.LecturerRepository;
//
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//
///**
// * @author @WilliamHenryKing
// * Desc: Implementation for LecturerRepository
// * Date: 2020/08/30
// **/
//
//public class LecturerRepositoryImpl implements LecturerRepository {
//
//    private static LecturerRepository lecturerRepository = null;
//    private Set<Lecturer> lecturerSet;
//
//    private LecturerRepositoryImpl() {
//
//        this.lecturerSet = new HashSet<>();
//
//    }
//
//    public static LecturerRepository getLecturerRepository() {
//
//        if (lecturerRepository == null){
//            lecturerRepository = new LecturerRepositoryImpl();
//        }
//
//        return lecturerRepository;
//
//    }
//
//    @Override
//    public Lecturer create(Lecturer lecturer) {
//        this.lecturerSet.add(lecturer);
//        return lecturer;
//    }
//
//    @Override
//    public Lecturer read(Long l) {
//        Lecturer lecturer = this.lecturerSet
//                .stream()
//                .filter(x -> x.getLecturerID() == l)
//                .findAny()
//                .orElse(null);
//
//        return lecturer;
//    }
//
//    @Override
//    public Lecturer update(Lecturer lecturer) {
//        if (!delete(lecturer.getLecturerID())) {
//            this.lecturerSet.add(lecturer);
//            return lecturer;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(Long l) {
//        Lecturer lecturer = read(l);
//        if (lecturer != null) {
//            this.lecturerSet.remove(lecturer);
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    @Override
//    public Set<Lecturer> getAll() {
//        return this.lecturerSet;
//    }
//
//}
