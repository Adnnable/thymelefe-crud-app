package snippet;

public class Snippet {
	spring.application.name=lms
	
	# Dynamic Database Configuration for Deployment
	spring.datasource.url=${SPRING_DATASOURCE_URL}
	spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
	spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}
	spring.datasource.driver-class-name=org.postgresql.Driver
	
	# Hibernate settings
	spring.jpa.hibernate.ddl-auto=update
	# Set show-sql to false in production to keep logs clean
	spring.jpa.show-sql=false
	spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
	
	# Thymeleaf settings
	spring.thymeleaf.cache=false
	
}

