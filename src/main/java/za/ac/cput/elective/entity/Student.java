package za.ac.cput.elective.entity;

/* Student class
Author: Sean Trainor 218060033
 */

public class Student {
    private int year;
    private String stream;
    private int studentID;


    private Student(Builder b) {
        this.studentID = b.studentID;
        this.stream = b.stream;
        this.year = b.year;

    }

    public int getStudentID() {
        return studentID;
    }

    public int getYear() {
        return year;
    }

    public String getStream() {
        return stream;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", year=" + year +
                ", stream='" + stream + '\'' +
                '}';
    }

    public static class Builder {

        private int studentID;
        private int year;
        private String stream;

        public Builder setStudentID(int studentID) {
            this.studentID = studentID;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Builder setStream(String stream) {
            this.stream = stream;
            return this;
        }

        public Builder copy(Student s) {
            this.studentID = s.studentID;
            this.stream = s.stream;
            this.year = s.year;
            return this;
        }

        public Student build() {
            return new Student(this);
        }

    }
}
