package entities.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserElement {
    @JsonProperty("UserHeight")
    Integer userHeight;
    @JsonProperty("UserBirthdayDay")
    Integer userBirthdayDay;
    @JsonProperty("UserBirthdayMonth")
    Integer userBirthdayMonth;
    @JsonProperty("UserBirthdayYear")
    Integer userBirthdayYear;
    @JsonProperty("UserStepLength")
    Integer userStepLength;
    @JsonProperty("UserSex")
    Boolean userSex;

    public Integer getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(Integer userHeight) {
        this.userHeight = userHeight;
    }


    public Integer getUserBirthdayDay() {
        return userBirthdayDay;
    }

    public void setUserBirthdayDay(Integer userBirthdayDay) {
        this.userBirthdayDay = userBirthdayDay;
    }

    public Integer getUserBirthdayMonth() {
        return userBirthdayMonth;
    }

    public void setUserBirthdayMonth(Integer userBirthdayMonth) {
        this.userBirthdayMonth = userBirthdayMonth;
    }

    public Integer getUserBirthdayYear() {
        return userBirthdayYear;
    }

    public void setUserBirthdayYear(Integer userBirthdayYear) {
        this.userBirthdayYear = userBirthdayYear;
    }

    public Integer getUserStepLength() {
        return userStepLength;
    }

    public void setUserStepLength(Integer userStepLength) {
        this.userStepLength = userStepLength;
    }

    public Boolean getUserSex() {
        return userSex;
    }

    public void setUserSex(Boolean userSex) {
        this.userSex = userSex;
    }
}
