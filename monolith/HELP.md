# Getting Started
The project aiming to demonstrate use of different technologies in monolith architecture. Side effect of this approach is 
need of using some kind of toggles to switch between them. <br />
Project has only on simple entity - Person, with name and id. 

### model
Starts from here, I've created a Person class. That is the entity that will represent data from DB.

### config
I choose Spring JdbcTemplate to perform interactions with database. 
As I want to make possible switches between two databases, I've created two datasource beans and two NamedParameterJdbcTemplate beans.
One of datasource marked as @Primary - try to remove it to see what happens. To avoid conflicts on beans injecting, 
I've assigned them names using name parameter of @Bean annotation. Usually, if you have two beans of one class, you need to use
@Qualifier annotation to point Spring on what should be injected using bean name.<br />

There are two connection beans for both databases created in configuration. It's highly unlikable that you'll even need both of 
them simultaneously, most likely that one of them will be defined on compile time. Usually you want to avoid creating unnecessary 
beans by using @ConditionalOnProperty, as in `mvc` package has been done. To have both connections, both PostgreSQL and MariaDB 
drivers has been added in pom.xml

### dao
There is only one DAO, for Person entity, with only one `find` method. The special in this method is the way JdbcTemplate injects:
1. Spring context accessible and injectable everywhere in spring application. I've injected it in constructor.
2. I use @Value("${dbtype:mysql}") to read `dbtype` property value from application property file. This value should be one 
of that I use in @Bean(name = "mysql") - it is a name of the NamedParameterJdbcTemplate bean.
3. In constructor, I get reference to the bean and inject it id class property.

Take a look at `resources` folder: there are two *.properties files there. That way I can define so called SpringProfiles.
In /test/java/com/tutrit/moduleswithcer/monolith/dao, you'll find two tests with @ActiveProfiles annotation. One test will
use MariaDB connection, because of @ActiveProfiles("mysql") the value for dbtype will be read from application-mysql.properties, and 
witch is mysql, and then be used in PersonDao to get bean named "mysql" to inject JdbcTemplate. That proved by assertion value `maria`. 
For postgre test it is `PostgreSQL`. Run tests and see the difference.
It is possible to get connection metadata, such as db vendor, url, user, password, transaction isolation and number of active 
connection from DataSource instance. That used to make an assertion for vendor of database PersonDao connected to.

### controller
I have 3 controllers here: for rest, mvc, and console interaction. They have just one endpoint to get Person from database.
Rest and Mvc controllers are bind to the same endpoint - "/person/{id}": that is why they cannot be instantiated simultaneously.
To switch between them, I use @ConditionalOnProperty(prefix = "controller", name = "type", havingValue = "mvc") annotation and 
`controller.type` property in application.properties file. Remove annotation or change property value to see the difference. <br />
Otherwise cmd controller: by omitting `havingValye` I got just feature toggle in application.properties that works 
by setting true/false value on controller.cmd property or completely removing it. <br />
If @ConditionalOnProperty doesn't meet condition, Spring will not create a bean in the first place: that is common behavior you'd like to have.
@EnableInConsoleCommands from cmd package is a good example of use of annotation inheritance: by placing 
@ConditionalOnProperty on top of the annotation, I concentrated property settings for condition in one place (S of solid and DRY).

### proxy
By proxy I mean a class that helps make requests over http. I've created a DummyController just to make an endpoint to call
proxy, and a PersonGateway in implementations of witch I can try different technologies to make calls overt http.
To be independent of 3d party resources and keep this app simple, I'll call existed /person/{id} endpoint that returns Person from database,
witch means that `rest`type should be enabled in application.properties.

The same way as with dao, I gave names for ProxyGateway implementation beans and make them injectable by the name in DummyController.
Feign implementation - is a technology very similar for SpringData and SpringWeb: we got an interface, and we just need 
to declare endpoint and method with annotation, parameter to pass and type to retrieve - All other job encapsulated by Feign.
Because of using interface I've wrapped it into implementation class PersonGatewayFeignImpl.

RestTemplateImpl, otherwise, is needs developer configuration. That is why I've added RestTemplateConfig that returns RestTemplate bean
without any additional configurations. Usually you would like to have separate RestTemplate beans for every http resource 
with predefined configuration like baseUrl, headers, security tokens ect. 

Like with Controllers or Dao, you'd rather prefer avoid creating unused beans by adding @ConditionalOnProperty annotation.
This example aims to demonstrate possibility to inject different beans implementation based on bean name rather than type,
and conditions of that injection could be easily moved from application.properties to some kind of runtime condition, even if it's rare and strange solution. 

### service
Usually service layer is a place where you will have all your business logic. From one side, it is controller that provides
user input to service, from the other - it is dao that saves result of service work. As we don't do any kind of business work,
this one just takes value and pass it forward, nothing interesting.
