import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    // прописываем метод, который будет обращаться к application.conf и читать его содержимое
    static Config readConfig(){
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");

    }

    // если нам нужно взять url
    String URL = readConfig().getString("url");
    // если нужно взять другое значение (в нашем случае - age)
    Integer AGE = readConfig().getInt("age");
    // теперь получаем параметры из конструкций
    String ADMIN_LOGIN = readConfig().getString("usersParams.admin.login");
    String DEMO_PASSWORD = readConfig().getString("usersParams.demo.password");
    // получаем логическое значение
    Boolean IS_DEMO_ADMIN = readConfig().getBoolean("usersParams.demo.isAdmin");
}
