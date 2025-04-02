package src;

/**
 * Represents a user of the system
 */
public class User {
    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * @return User's full name
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getEmail() {
        return email;
    }
    
    /**
     * Users are considered equal if they have the same email
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof User)) return false;
        User other = (User) obj;
        return this.email.equals(other.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}