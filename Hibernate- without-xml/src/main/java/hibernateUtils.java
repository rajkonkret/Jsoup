import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


import java.util.Properties;

public class hibernateUtils {
    private final SessionFactory  sesionFactory;

    public hibernateUtils(SessionFactory sesionFactory) {
        this.sesionFactory = sesionFactory;
    }

    private SessionFactory getSesionFactory(){
        if (sesionFactory != null){
            return sesionFactory;
        }
        try {
            Configuration configuration = new Configuration();
            Properties properties = new Properties();
            properties.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
            properties.put(Environment.URL, "");
            properties.put(Environment.USER,"");
            properties.put(Environment.PASS,"");
            properties.put(Environment.FORMAT_SQL,"true");
            properties.put(Environment.SHOW_SQL,"true");
            properties.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
            properties.put(Environment.HBM2DDL_AUTO, "update");
            configuration.setProperties(properties);
            configuration.addAnnotatedClass(Person.class); //do adnotacji @Entity
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySetting(configuration.gert)
                    .build();
            sesionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return
    }
}
