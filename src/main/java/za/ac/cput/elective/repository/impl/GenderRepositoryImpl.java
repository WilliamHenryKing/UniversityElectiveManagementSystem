//package za.ac.cput.elective.repository.impl;
//
//
//import za.ac.cput.elective.entity.Gender;
//import za.ac.cput.elective.repository.GenderRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * @author @WilliamHenryKing
// * Desc: Implementation for GenderRepository
// * Date: 2020/08/30
// **/
//
//public class GenderRepositoryImpl implements GenderRepository {
//
//    private static GenderRepository genderRepository = null;
//    private Set<Gender> genderSet;
//
//    private GenderRepositoryImpl() {
//
//        this.genderSet = new HashSet<>();
//
//    }
//
//    public static GenderRepository getGenderRepository() {
//
//        if (genderRepository == null){
//            genderRepository = new GenderRepositoryImpl();
//        }
//
//        return genderRepository;
//    }
//
//    @Override
//    public Gender create(Gender gender) {
//        this.genderSet.add(gender);
//        return gender;
//    }
//
//    @Override
//    public Gender read(Character c) {
//
//        return this.genderSet
//                .stream()
//                .filter(x -> x.getGenderID() == c)
//                .findAny()
//                .orElse(null);
//    }
//
//    @Override
//    public Gender update(Gender gender) {
//        if (!delete(gender.getGenderID())) {
//            this.genderSet.add(gender);
//            return gender;
//        }
//        return null;
//    }
//
//    @Override
//    public boolean delete(Character c) {
//        Gender gender = read(c);
//        if (gender != null) {
//            this.genderSet.remove(gender);
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    @Override
//    public Set<Gender> getAll() {
//        return this.genderSet;
//    }
//
//}
