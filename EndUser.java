package usecase;

public class EndUser {
    private String id;
    private EndUserRole role;

    public EndUser(String id, EndUserRole role) {
        this.id = id;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public EndUserRole getRole() {
        return role;
    }
}

