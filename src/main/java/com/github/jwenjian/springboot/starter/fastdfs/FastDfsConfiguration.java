package com.github.jwenjian.springboot.starter.fastdfs;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@EnableConfigurationProperties(FastDfsProperties.class)
public class FastDfsConfiguration {

    @Autowired
    private FastDfsProperties fastDfsProperties;


    @Bean
    public FastDfsManager fastDfsStorageClient() throws IOException, MyException {
        // do the init
        ClientGlobal.initByProperties(fastDfsProperties.getProperties());

        final TrackerClient trackerClient = new TrackerClient();
        final TrackerServer trackerServer = trackerClient.getConnection();
        final StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
        final StorageClient1 storageClient1 = new StorageClient1(trackerServer, storageServer);

        return new FastDfsManager(trackerClient, trackerServer, storageServer, storageClient1);
    }
}
