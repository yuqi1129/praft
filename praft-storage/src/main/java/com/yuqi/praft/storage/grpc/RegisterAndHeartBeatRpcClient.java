/* (C)2021 */
package com.yuqi.praft.storage.grpc;

import com.yuqi.praft.RegisterAndHeartBeatProtos;
import com.yuqi.praft.RegisterAndHeartBeatServiceGrpc;
import com.yuqi.praft.common.proto.GrpcClient;

/**
 * @author yuqi
 * @mail yuqi4733@gmail.com
 * @description your description
 * @time 22/1/21 下午7:56
 */
public class RegisterAndHeartBeatRpcClient extends GrpcClient {
    private RegisterAndHeartBeatServiceGrpc.RegisterAndHeartBeatServiceBlockingStub stub;

    public RegisterAndHeartBeatRpcClient(String host, int port) {
        super(host, port);
    }

    public void registerLocation(String host, int port) {
        RegisterAndHeartBeatProtos.NodeRegisterRequest.Builder builder =
                RegisterAndHeartBeatProtos.NodeRegisterRequest.newBuilder();

        builder.setHostname(host);
        builder.setPort(port);

        if (stub == null) {
            stub = RegisterAndHeartBeatServiceGrpc.newBlockingStub(managedChannel);
        }

        RegisterAndHeartBeatProtos.NodeRegisterReponse r = stub.registerNodeInfo(builder.build());

        if (r.getCode() == 0) {
            LOGGER.info("Register stoarge successful to execution server...");
        } else {
            LOGGER.error("Failed register...");
        }
    }
}
