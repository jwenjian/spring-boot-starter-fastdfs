# spring-boot-starter-fastdfs
A spring boot starter for fastdfs java client. [![](https://jitpack.io/v/jwenjian/spring-boot-starter-fastdfs.svg)](https://jitpack.io/#jwenjian/spring-boot-starter-fastdfs)

## Why
Normally, we use the fastdfs java client in the `fastdfs_client.conf` way.
It works well, util we start to using spring boot.

The configuration file way cannot meet out active profile of spring boot, like: `dev`, `test`, `pro`, we want
the client more *smart* in a spring boot way.

So, here it comes.

## How to install
1. Add a maven repository to your `pom.xml`
```xml
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```
2. Add the dependency
```xml
	<dependency>
	    <groupId>com.github.jwenjian</groupId>
	    <artifactId>spring-boot-starter-fastdfs</artifactId>
	    <version>${version}</version>
	</dependency>
```
## How to config
If you know how to config original `client_conf.properties`, then you will know how to config this project.

Add configuration items to your `application-${profile}.properties` or `application-${profile}.yml`:

- Properties
```properties
spring.fastdfs.tracker_servers= # the tracker server urls
spring.fastdfs.connect_timeout_in_seconds= # the connect timeout in seconds
spring.fastdfs.network_timeout_in_seconds= # the network timeout in seconds
spring.fastdfs.charset= # the.charset
spring.fastdfs.http_anti_steal_token= # the http anti-steal token
spring.fastdfs.http_secret_key= # the http secret key
spring.fastdfs.http_tracker_http_port= # the http tracker http port
spring.fastdfs.init_conn_on_load= # if init connection on server loaded
```

- Yaml
```yaml
spring:
    fastdfs:
        tracker_servers: # the tracker server urls
        connect_timeout_in_seconds: # the connect timeout in seconds
        network_timeout_in_seconds: # the network timeout in seconds
        charset: # the.charset
        http_anti_steal_token: # the http anti-steal token
        http_secret_key: # the http secret key
        http_tracker_http_port: # the http tracker http port
        init_conn_on_load: # if init connection on server loaded
```

## How to use

Below is the sample code:
```java
@RestController
public class DemoController {

    @Autowired
    private FastDfsManager fastDfsManager;


    @PostMapping("/upload")
    public void upload(final MultipartFile file) throws IOException, MyException {
        final String[] results = fastDfsManager.getStorageClient1().upload_file(file.getBytes(), "jpg", null);

        System.out.println(Arrays.toString(results));
    }

}
```
