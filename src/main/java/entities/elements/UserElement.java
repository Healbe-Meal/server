package entities.elements;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserElement {
    @JsonProperty("UserHeight")
    Integer UserHeight;
    @JsonProperty("UserBirthdayDay")
    Integer UserBirthdayDay;
    @JsonProperty("UserBirthdayMonth")
    Integer UserBirthdayMonth;
    @JsonProperty("UserBirthdayYear")
    Integer UserBirthdayYear;
    @JsonProperty("UserStepLength")
    Integer UserStepLength;
    @JsonProperty("UserSex")
    Boolean UserSex;

    public Integer getUserHeight() {
        return UserHeight;
    }

    public void setUserHeight(Integer userHeight) {
        UserHeight = userHeight;
    }

    public Integer getUserBirthdayDay() {
        return UserBirthdayDay;
    }

    public void setUserBirthdayDay(Integer userBirthdayDay) {
        UserBirthdayDay = userBirthdayDay;
    }

    public Integer getUserBirthdayMonth() {
        return UserBirthdayMonth;
    }

    public void setUserBirthdayMonth(Integer userBirthdayMonth) {
        UserBirthdayMonth = userBirthdayMonth;
    }

    public Integer getUserBirthdayYear() {
        return UserBirthdayYear;
    }

    public void setUserBirthdayYear(Integer userBirthdayYear) {
        UserBirthdayYear = userBirthdayYear;
    }

    public Integer getUserStepLength() {
        return UserStepLength;
    }

    public void setUserStepLength(Integer userStepLength) {
        UserStepLength = userStepLength;
    }

    public Boolean getUserSex() {
        return UserSex;
    }

    public void setUserSex(Boolean userSex) {
        UserSex = userSex;
    }
}


