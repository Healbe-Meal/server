package entities.response;

public class UserInfo {
    Integer height;
    Integer stepLength;
    Boolean sex;
    Integer age;

    public UserInfo(Integer height, Integer birthdayDay, Integer birthdayMonth, Integer birthdayYear, Integer stepLength, Boolean sex) {
        this.height = height;
        this.stepLength = stepLength;
        this.sex = sex;
        this.age = 31;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getStepLength() {
        return stepLength;
    }

    public void setStepLength(Integer stepLength) {
        this.stepLength = stepLength;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
}
