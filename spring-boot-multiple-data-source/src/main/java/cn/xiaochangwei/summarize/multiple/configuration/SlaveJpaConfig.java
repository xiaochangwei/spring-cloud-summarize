package cn.xiaochangwei.summarize.multiple.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * create by changw.xiao@qq.com at 2018/11/20 10:46
 **/
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "slaveEntityManagerFactory", transactionManagerRef = "slaveJpaTransactionManager", basePackages = {"cn.xiaochangwei.summarize.multiple.dao.jpa.slave"})
public class SlaveJpaConfig {
    @Autowired
    @Qualifier("slaveDataSource")
    private DataSource slaveDataSource;

    @Autowired
    private JpaProperties jpaProperties;

    @Bean(name = "slaveEntityManager")
    public EntityManager slaveEntityManager(EntityManagerFactoryBuilder builder) {
        return slaveEntityManagerFactory(builder).getObject().createEntityManager();
    }

    @Bean(name = "slaveEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean slaveEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(slaveDataSource).properties(getVendorProperties())
                .packages("cn.xiaochangwei.summarize.multiple.entity.slave")
                .persistenceUnit("slavePersistenceUnit").build();
    }

    private Map<String, String> getVendorProperties() {
        return jpaProperties.getProperties();
    }

    @Bean(name = "slaveJpaTransactionManager")
    public PlatformTransactionManager slaveTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(slaveEntityManagerFactory(builder).getObject());
    }
}
