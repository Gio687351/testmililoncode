package refactula.design.patterns.builder;

import java.util.List;

public class UserStorage {
    private final List<User> users;

    public UserStorage(List<User> users) {
        this.users = users;
    }

    public void record(ReportBuilder reportBuilder) {
        for (User user : users) {
            user.record(reportBuilder);
        }
    }
}
