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

### service 
Usually we have service layer between controller and dao. this one just passing forward value, nothing interesting.

### controller
I have 3 controllers here: for rest, mvc, and console interaction. They have just one endpoint to get Person from database.
Rest and Mvc controllers are bind to the same endpoint - "/person/{id}": that is why they cannot be instantiated simultaneously.
To switch between them, I use @ConditionalOnProperty(prefix = "controller", name = "type", havingValue = "mvc") annotation and 
`controller.type` property in application.properties file. Remove annotation or change property value to see the difference. <br />
Otherwise cmd controller: by omitting `havingValye` I got just feature toggle in application.properties that works 
by setting true/false value on controller.cmd property or completely removing it. <br />
If @ConditionalOnProperty doesn't meet condition, Spring will not create a bean in the first place: that is common behavior you'd like to have.
@EnableInConsoleCommands from cmd package is a good example of use of annotation inheritance: by placing 
@ConditionalOnProperty on top of the annotation, I focus property settings for condition in one place (S of solid and DRY).



