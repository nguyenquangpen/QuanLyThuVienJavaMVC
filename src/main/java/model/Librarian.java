package model;

public class Librarian {
    private String username;
    private String password;
    private int LibrarianID;
    private String employeeCard;
    public Librarian(int librarianID, String employeeCard) {
        this.LibrarianID = librarianID;
        this.employeeCard = employeeCard;
    }

    public Librarian(String username, String password, int librarianID) {
        this.username = username;
        this.password = password;
        this.LibrarianID = librarianID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLibrarianID() {
        return LibrarianID;
    }

    public void setLibrarianID(int librarianID) {
        LibrarianID = librarianID;
    }

    public String getEmployeeCard() {
        return employeeCard;
    }

    public void setEmployeeCard(String employeeCard) {
        this.employeeCard = employeeCard;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", LibrarianID=" + LibrarianID +
                ", employeeCard='" + employeeCard + '\'' +
                '}';
    }
}
