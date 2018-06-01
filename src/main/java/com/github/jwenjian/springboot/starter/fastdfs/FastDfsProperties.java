package com.github.jwenjian.springboot.starter.fastdfs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * Properties bean mapping spring.fastdfs.* config items.
 *
 * @author jwenjian
 */
@Component
@ConfigurationProperties(prefix = "spring.fastdfs")
public class FastDfsProperties {

    /**
     * The properties instance
     */
    private Properties properties;

    /**
     * The value configured by 'spring.fastdfs.tracker_servers'
     */
    private String trackerServers;

    /**
     * The value configured by 'spring.fastdfs.connect_timeout_in_seconds'
     */
    private Integer connectTimeoutInSeconds;

    /**
     * The value configured by 'spring.fastdfs.network_timeout_in_seconds'
     */
    private Integer networkTimeoutInSeconds;

    /**
     * The value configured by 'spring.fastdfs.charset'
     */
    private String charset;

    /**
     * The value configured by 'spring.fastdfs.http_anti_steal_token'
     */
    private Boolean httpAntiStealToken;

    /**
     * The value configured by 'spring.fastdfs.http_secret_key'
     */
    private String httpSecretKey;

    /**
     * The value configured by 'spring.fastdfs.http_tracker_http_port'
     */
    private Integer httpTrackerHttpPort;

    /**
     * The value configured by 'spring.fastdfs.init_conn_on_load'
     * This item was designed for this starter to give you the control the timing to init the connection, default to true
     */
    private Boolean initConnOnLoad = true;

    public Properties getProperties() {
        return properties;
    }

    public String getTrackerServers() {
        return trackerServers;
    }

    public Integer getConnectTimeoutInSeconds() {
        return connectTimeoutInSeconds;
    }

    public Integer getNetworkTimeoutInSeconds() {
        return networkTimeoutInSeconds;
    }

    public String getCharset() {
        return charset;
    }

    public Boolean getHttpAntiStealToken() {
        return httpAntiStealToken;
    }

    public String getHttpSecretKey() {
        return httpSecretKey;
    }

    public Integer getHttpTrackerHttpPort() {
        return httpTrackerHttpPort;
    }

    public void setTrackerServers(String trackerServers) {
        this.trackerServers = trackerServers;
    }

    public void setConnectTimeoutInSeconds(Integer connectTimeoutInSeconds) {
        this.connectTimeoutInSeconds = connectTimeoutInSeconds;
    }

    public void setNetworkTimeoutInSeconds(Integer networkTimeoutInSeconds) {
        this.networkTimeoutInSeconds = networkTimeoutInSeconds;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public void setHttpAntiStealToken(Boolean httpAntiStealToken) {
        this.httpAntiStealToken = httpAntiStealToken;
    }

    public void setHttpSecretKey(String httpSecretKey) {
        this.httpSecretKey = httpSecretKey;
    }

    public void setHttpTrackerHttpPort(Integer httpTrackerHttpPort) {
        this.httpTrackerHttpPort = httpTrackerHttpPort;
    }

    public Boolean getInitConnOnLoad() {
        return initConnOnLoad;
    }

    public void setInitConnOnLoad(Boolean initConnOnLoad) {
        this.initConnOnLoad = initConnOnLoad;
    }

    @PostConstruct
    private void initProperties() {
        if (properties != null) {
            properties.clear();
        } else {
            properties = new Properties();
        }

        setFastDfsProperty(FastDfsConfigKeyConstant.KEY_TRACKER_SERVERS, trackerServers);
        setFastDfsProperty(FastDfsConfigKeyConstant.KEY_CONN_TIMEOUT_IN_SECONDS, connectTimeoutInSeconds);
        setFastDfsProperty(FastDfsConfigKeyConstant.KEY_NETWORK_TIMEOUT_IN_SECONDS, networkTimeoutInSeconds);
        setFastDfsProperty(FastDfsConfigKeyConstant.KEY_CHARSET, charset);
        setFastDfsProperty(FastDfsConfigKeyConstant.KEY_HTTP_ANTI_STEAL_TOKEN, httpAntiStealToken);
        setFastDfsProperty(FastDfsConfigKeyConstant.KEY_HTTP_SECRET_KEY, httpSecretKey);
        setFastDfsProperty(FastDfsConfigKeyConstant.KEY_HTTP_TRACKER_HTTP_PORT, httpTrackerHttpPort);
    }

    private void setFastDfsProperty(String key, Object value) {
        if (value == null) {
            return;
        }
        properties.setProperty(key, value.toString());
    }

}
