/* (C)2021 */
package com.yuqi.praft.storage;

/**
 * @author yuqi
 * @mail yuqi5@xiaomi.com
 * @description your description
 * @time 25/4/21 下午8:23
 */
public class StorageMain {

    public static void main(String[] args) {
        // 1. load config

        // 2. init raft

        // 3. init node info and register to manger

        // 3.

        // node

        /**
         * * 1. 起动PD 2. 起动KV, 节点注册, 读取持久化的region信息上报PD，如果是新建的集群，开始并没有region信息 3. 客户端写入数据，查PD
         * 改数据对应的region，如果是首次写入的话，可能没有region信息，PD调接口KV节点起一个raft group 并将region信息 持久化 选择KV结点，起动mutli
         * Raft服务， 并写入持久信息 4. 客户端得到region的master节点， 开始写入
         *
         * <p>举例: PD
         *
         * <p>KV1 KV2 KV3 KV4....
         *
         * <p>比如说我想写入一条数据 1. client ---> PD 查region, PD的region信息是空的， PD于是选择其中的三个KV 起动一个multi raft,
         * 选主完成之后，PD 将region信息写入这三个KV节点中 2. client 从PD 那里得到region的master节点， 开始写入
         *
         * <p>重启: PD最先启动 KV1, KV2, KV3 KV4, KV5 以此启动 假设刚刚选择的是KV1, KV2, KV4 则KV1, KV2,
         * KV4这三个节在向PD注册结果的同时，也会去扫描region信息，将region也注册上，于是PD中初始有一个region
         */
    }
}
