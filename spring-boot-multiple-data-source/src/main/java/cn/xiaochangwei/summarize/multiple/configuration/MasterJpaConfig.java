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
@EnableJpaRepositories(entityManagerFactoryRef = "masterEntityManagerFactory", transactionManagerRef = "masterJpaTransactionManager", basePackages = {"cn.xiaochangwei.summarize.multiple.dao.jpa.master"})
public class MasterJpaConfig {
    @Autowired
    @Qualifier("masterDataSource")
    private DataSource masterDataSource;

    @Autowired
    private JpaProperties jpaProperties;

    @Primary
    @Bean(name = "masterEntityManager")
    public EntityManager masterEntityManager(EntityManagerFactoryBuilder builder) {
        return masterEntityManagerFactory(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "masterEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean masterEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(masterDataSource).properties(getVendorProperties())
                .packages("cn.xiaochangwei.summarize.multiple.entity.master")
                .persistenceUnit("masterPersistenceUnit").build();
    }

    private Map<String, String> getVendorProperties() {
        return jpaProperties.getProperties();
    }

    @Primary
    @Bean(name = "masterJpaTransactionManager")
    public PlatformTransactionManager masterTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(masterEntityManagerFactory(builder).getObject());
    }
}
