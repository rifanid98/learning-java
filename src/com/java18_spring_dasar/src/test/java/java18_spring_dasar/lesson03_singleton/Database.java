package java18_spring_dasar.lesson03_singleton;

public class Database {
    private static Database database;

    public static Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    private Database() {
    }
}
