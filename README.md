# Projeto springBootTodoList


<h3>Status do Projeto</h3>
<p align="center">  💻 Em construção... </p>

<h3>Features</h3>

- [x] Greetings<br>

<h3>Demostração da Aplicação</h3>
<p>Antes de começar, você precisará ter instalado em sua máquina as seguintes ferramentas:</p>
<table>
<tr>
	<th>Ferramenta</th>
	<th>Versão</th>
</tr>
<tr>
	<td>Java JDK</td>
	<td>17</td>
</tr>
<tr>
	<td>Spring Boot</td>
	<td>3.0.1</td>
</tr>
<tr>
	<td>H2</td>
	<td>In Memory</td>
</tr>
<tr>
	<td>Git</td>
	<td>Last One</td>
</tr>
<tr>
	<td>Maven</td>
	<td>7</td>
</tr>
<tr>
	<td>Insomnia</td>
	<td>Last One</td>
</tr>
<tr>
	<td>Lombok</td>
	<td>Last One</td>
</tr>

</table>
<h6>** Visando facilitar a demostração da aplicação, recomendo instalar apenas o IntelliJ IDEA e rodar o projeto através da IDE **</h6>

No Terminal/Console:
<ol>
	<li>Faça um clone do projeto na sua máquina: <code>git clone https://github.com/THONWELLING/rest-with-spring-boot-java.git</code></li>
	<li>Entre na pasta raiz do projeto: <code>cd rest-with-spring-boot-java</code></li> 
</ol>

## Trechos de código

### Plug-in Maven

```xml
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-resources-plugin</artifactId>
	<version>3.1.0</version> <!--$NO-MVN-MAN-VER$ -->
</plugin>
```

### application-test.properties

```
# H2 Connection
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

# H2 Client
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Show SQL
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

### WebConfig

Resumindo, esse arquivo de configuração define uma política de CORS na aplicação, permitindo que todas as origens definidas em corsOrigins possam fazer requisições para todas as URLs da aplicação, usando todos os métodos HTTP disponíveis. Essa configuração é útil quando você precisa permitir o acesso de origens externas à sua aplicação por meio de requisições CORS.

```java
@Configuration
public class WebConfig {

	@Value("${cors.origins}")
	private String corsOrigins;
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("*").allowedOrigins(corsOrigins);
			}
		};
	}
	
}
```