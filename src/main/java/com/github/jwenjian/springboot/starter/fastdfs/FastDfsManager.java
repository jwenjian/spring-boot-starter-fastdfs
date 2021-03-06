package com.github.jwenjian.springboot.starter.fastdfs;

import org.csource.fastdfs.*;

/**
 * A manager(wrapper) of original fastdfs client.
 *
 * @author jwenjian
 */
public class FastDfsManager {

    private TrackerClient trackerClient;

    private TrackerServer trackerServer;

    private StorageServer storageServer;

    private StorageClient1 storageClient1;

    /**
     * Constructor
     *
     * @param trackerClient Initialized tracker client instance
     * @param trackerServer Initialized tracker server instance
     * @param storageServer Initialized storage server instance
     * @param storageClient1 Initialized storage client1 instance
     */
    FastDfsManager(TrackerClient trackerClient, TrackerServer trackerServer, StorageServer storageServer, StorageClient1 storageClient1) {
        this.trackerClient = trackerClient;
        this.trackerServer = trackerServer;
        this.storageServer = storageServer;
        this.storageClient1 = storageClient1;
    }

    public TrackerClient getTrackerClient() {
        return trackerClient;
    }

    public TrackerServer getTrackerServer() {
        return trackerServer;
    }

    public StorageServer getStorageServer() {
        return storageServer;
    }

    public StorageClient1 getStorageClient1() {
        return storageClient1;
    }
}
