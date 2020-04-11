package com.example.agenda.user;

public class User {
    public String email;
    public String username;
    public String password;
    public String userId;

    public User(String email, String username, String password, String userId) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.userId = userId;
    }

    /**
     * Change this user's password iff user enters password correctly for twice,
     * and the new password is not same as the old password
     *
     * @param newPassword User's input of new password
     * @param newPassword2 User's input of repeated new password
     * @return True iff password change is performed
     */
    public boolean changePassword(String newPassword, String newPassword2) {
        if (newPassword.equals(newPassword2) && !(newPassword.equals(this.password))) {
            this.password = newPassword;
            return true;
        } else {
            return false;
        }
    }
}

