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
# spring.fastdfs.tracker_servers=
# spring.fastdfs.connect_timeout_in_seconds=
# spring.fastdfs.network_timeout_in_seconds=
# spring.fastdfs.charset=
# spring.fastdfs.http_anti_steal_token=
# spring.fastdfs.http_secret_key=
# spring.fastdfs.http_tracker_http_port=
```

- Yaml
```yaml
spring:
    fastdfs:
        # tracker_servers:
        # connect_timeout_in_seconds:
        # network_timeout_in_seconds:
        # charset: UTF-8
        # http_anti_steal_token:
        # http_secret_key:
        # http_tracker_http_port:
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
