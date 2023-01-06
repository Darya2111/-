import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PropertiesTest extends BaseForTest{
    // 1й способ чтения конфигурационного файла (из "application.properties")
    @Test
    public void readProperties() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("application.properties"));
        String urlFromProperty = System.getProperty("url");
        System.out.println(urlFromProperty);
    }

    // 2й способ чтения конфигурационного файла из "application.conf"
    @Test
    public void readFromConf(){
        // тут нужно использовать библиотеку typesafe
        String urlFromConfig = ConfigProvider.URL;
        System.out.println(urlFromConfig);
        Boolean isDemoAdmin = ConfigProvider.IS_DEMO_ADMIN;
        System.out.println(isDemoAdmin);
        if(ConfigProvider.readConfig().getBoolean("usersParams.admin.isAdmin")){
            System.out.println("Админ действительно админ");
        } else{
            System.out.println("12");
        }
    }
}
