package com.diysolutions.dto.authentication;

public class SignupRequest {
    private String email;
    private String password;
    private String fullName;

    public SignupRequest(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public SignupRequest() {
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof SignupRequest)) return false;
        final SignupRequest other = (SignupRequest) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$fullName = this.getFullName();
        final Object other$fullName = other.getFullName();
        if (this$fullName == null ? other$fullName != null : !this$fullName.equals(other$fullName)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SignupRequest;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $fullName = this.getFullName();
        result = result * PRIME + ($fullName == null ? 43 : $fullName.hashCode());
        return result;
    }

    public String toString() {
        return "SignupRequest(email=" + this.getEmail() + ", password=" + this.getPassword() + ", fullName=" + this.getFullName() + ")";
    }
}