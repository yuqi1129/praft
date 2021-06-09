/* (C)2021 */
package com.yuqi.praft.manager.service;

import com.yuqi.praft.DdlProtos;
import com.yuqi.praft.DdlServiceGrpc;
import com.yuqi.praft.common.proto.GrpcClient;

/**
 * @author yuqi
 * @mail yuqi4733@gmail.com
 * @description your description
 * @time 22/1/21 下午7:59
 */
public class DdlServiceClient extends GrpcClient {
    private DdlServiceGrpc.DdlServiceBlockingStub stub;

    public DdlServiceClient(String host, int port) {
        super(host, port);
    }

    private void executeCreateTable(String tableName) {
        if (stub == null) {
            stub = DdlServiceGrpc.newBlockingStub(managedChannel);
        }

        DdlProtos.CreateTableRequest.Builder b = DdlProtos.CreateTableRequest.newBuilder();
        b.setTableName(tableName);
        DdlProtos.CreateTableResponse r = stub.createTable(b.build());
    }
}
