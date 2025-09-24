/*apenas para inicializar o flyaway*/
/* por algum motivo se tentamos ja inicializar no V1 ele simplesmente pula ele por conta do
   baseline-on-migrate: true, porem se desativamos esta opção da este erro:
   org.springframework.beans.factory.BeanCreationException:
   Error creating bean with name 'entityManagerFactory' defined in class path resource
   [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]:
   Failed to initialize dependency 'flywayInitializer' of LoadTimeWeaverAware bean
   'entityManagerFactory': Error creating bean with name 'flywayInitializer' defined in class path
   resource [org/springframework/boot/autoconfigure/flyway/FlywayAutoConfiguration$FlywayConfiguration.class]:
   Found non-empty schema(s) "RM554728" but no schema history table. Use baseline()
   or set baselineOnMigrate to true to initialize the schema history table.
 */