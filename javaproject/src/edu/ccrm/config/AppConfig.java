package ccrm.config;
public class AppConfig {
    private static AppConfig instance;
    private AppConfig() {}
    public static AppConfig getInstance() {
        if (instance == null) instance = new AppConfig();
        return instance;
    }
    public String getDataPath() { return "data"; }
}
