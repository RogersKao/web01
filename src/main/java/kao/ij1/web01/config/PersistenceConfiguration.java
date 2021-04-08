package kao.ij1.web01.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.url("jdbc:postgresql://localhost:5432/dlbunker");
        builder.username("postgres");
        builder.password("Rogers!2345");
        System.out.println("===000 ===My custom datasource bean has been initialized and set");
        return builder.build();
    }
}
