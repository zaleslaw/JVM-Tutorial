package beans;



public class Employee {

    private int age = 40;
    private String name = "Ivan";
    private String skill = "Java";
    private int level = 3;
    private Department department;

    public Employee() {
    }

    public Employee(int age, String name, String skill, int level, Department department) {
        this.name = name;
        this.age = age;
        this.skill = skill;
        this.level = level;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }



    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", level=" + level +
                ", department=" + department +
                '}';
    }
}