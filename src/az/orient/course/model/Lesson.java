package az.orient.course.model;

public class Lesson extends CourseModel {

    private String name;
    private Integer time;
    private Double price;
    private Teacher teacher;

    

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
     public String toString() {
        return name + "," + price + " AZN";
    }

}
