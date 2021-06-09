/* (C)2021 */
package com.yuqi.praft.manager.service;

import com.yuqi.praft.RegisterAndHeartBeatProtos;
import com.yuqi.praft.RegisterAndHeartBeatServiceGrpc;
import com.yuqi.praft.common.HostAndPort;
import com.yuqi.praft.manager.RegisterAndHeatBeatHandler;
import io.grpc.stub.StreamObserver;

/**
 * @author yuqi
 * @mail yuqi4733@gmail.com
 * @description your description
 * @time 19/1/21 下午8:29
 */
public class RegisterAndHeartBeatService
        extends RegisterAndHeartBeatServiceGrpc.RegisterAndHeartBeatServiceImplBase {
    private RegisterAndHeatBeatHandler registerAndHeatBeatHandler;

    public RegisterAndHeartBeatService(RegisterAndHeatBeatHandler registerAndHeatBeatHandler) {
        this.registerAndHeatBeatHandler = registerAndHeatBeatHandler;
    }

    @Override
    public void registerNodeInfo(
            RegisterAndHeartBeatProtos.NodeRegisterRequest request,
            StreamObserver<RegisterAndHeartBeatProtos.NodeRegisterReponse> responseObserver) {
        RegisterAndHeartBeatProtos.NodeRegisterReponse r =
                RegisterAndHeartBeatProtos.NodeRegisterReponse.newBuilder().setCode(0).build();
        final String host = request.getHostname();
        final int port = request.getPort();

        registerAndHeatBeatHandler.addNodeInfo(new HostAndPort(host, port));
        responseObserver.onNext(r);
        responseObserver.onCompleted();
    }
}
