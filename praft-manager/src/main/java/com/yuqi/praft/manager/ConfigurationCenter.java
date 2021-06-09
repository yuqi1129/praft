/* (C)2021 */
package com.yuqi.praft.manager;

import com.google.common.collect.Maps;
import com.google.common.net.HostAndPort;
import com.yuqi.praft.common.Startable;
import com.yuqi.praft.common.proto.GrpcServer;
import com.yuqi.praft.manager.service.DdlServiceClient;
import com.yuqi.praft.manager.service.RegisterAndHeartBeatService;
import io.grpc.BindableService;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yuqi
 * @mail yuqi4733@gmail.com
 * @description your description
 * @time 19/1/21 下午8:06
 */
public class ConfigurationCenter extends GrpcServer implements Startable {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationCenter.class);
    private static final Map<HostAndPort, DdlServiceClient> RPC_CLIENT_MAP = Maps.newHashMap();
    private RegisterAndHeatBeatHandler registerAndHeatBeatHandler =
            new RegisterAndHeatBeatHandler();

    public ConfigurationCenter(int port) {
        super(port);
    }

    @Override
    public List<BindableService> getService() {
        return Collections.singletonList(
                new RegisterAndHeartBeatService(registerAndHeatBeatHandler));
    }

    @Override
    public void start() {
        // start rpc
        startRpc();

        // block
        block();
    }
}
