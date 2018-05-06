package com.github.jwenjian.springboot.starter.fastdfs;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Spring boot auto configuration for fastdfs.
 *
 * @author jwenjian
 */
@Configuration
@EnableConfigurationProperties(FastDfsProperties.class)
public class FastDfsConfiguration {

    @Autowired
    private FastDfsProperties fastDfsProperties;


    @Bean
    public FastDfsManager fastDfsManager() throws IOException, MyException {
        // Do the init
        ClientGlobal.initByProperties(fastDfsProperties.getProperties());

        final TrackerClient trackerClient = new TrackerClient();
        final TrackerServer trackerServer = trackerClient.getConnection();
        final StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
        final StorageClient1 storageClient1 = new StorageClient1(trackerServer, storageServer);

        return new FastDfsManager(trackerClient, trackerServer, storageServer, storageClient1);
    }
}
