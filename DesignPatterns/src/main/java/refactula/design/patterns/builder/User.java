package refactula.design.patterns.builder;

public class User {
    private final int id;
    private final String name;
    private final String phone;

    public User(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public void record(ReportBuilder reportBuilder) {
        reportBuilder.addObjectValue(id);
        reportBuilder.addObjectValue(name);
        reportBuilder.addObjectValue(phone);
        reportBuilder.endRecord();
    }
}
