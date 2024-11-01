package bg.softuni.pathfinder.model.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

public class RegisterDTO {
    @NotBlank
    @Size(min = 3, max = 10)
    private String username;
    @NotBlank
    @Size(min = 3)
    private String fullName;
    @Email
    @NotBlank
    private String email;
    @NotNull
    @Min(14)
    private Integer age;
    @NotBlank
    @Size(min = 4, max = 10)
    private String password;
    @NotBlank
    @Size(min = 4, max = 10)
    private String confirmPassword;

    private boolean userIsExist;

    private boolean emailIsExist;

    private boolean unConfPass;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isUserIsExist() {
        return userIsExist;
    }

    public void setUserIsExist(boolean userIsExist) {
        this.userIsExist = userIsExist;
    }

    public boolean isEmailIsExist() {
        return emailIsExist;
    }

    public void setEmailIsExist(boolean emailIsExist) {
        this.emailIsExist = emailIsExist;
    }

    public boolean isUnConfPass() {
        return unConfPass;
    }

    public void setUnConfPass(boolean unConfPass) {
        this.unConfPass = unConfPass;
    }
}
