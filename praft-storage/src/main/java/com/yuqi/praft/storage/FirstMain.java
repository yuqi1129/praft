/* (C)2021 */
package com.yuqi.praft.storage;

import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.rocksdb.RocksIterator;

/**
 * @author yuqi
 * @mail yuqi5@xiaomi.com
 * @description your description
 * @time 25/4/21 下午8:04
 */
public class FirstMain {
    static {
        RocksDB.loadLibrary();
    }

    public static void main(String[] args) {
        final String storagePath = "/Users/yuqi/test/rocksdb";

        Options options = new Options();
        options.setCreateIfMissing(true);

        try (RocksDB rocksDB = RocksDB.open(options, storagePath)) {
            for (int i = 0; i < 10000; i++) {
                rocksDB.put(String.valueOf(i).getBytes(), String.valueOf(i * i).getBytes());
            }
        } catch (RocksDBException e) {
            e.printStackTrace();
        }

        try (RocksDB rocksDB = RocksDB.open(options, storagePath)) {
            RocksIterator rocksIterator = rocksDB.newIterator();
            rocksIterator.seekToFirst();

            while (rocksIterator.isValid()) {
                System.out.println(
                        "key = "
                                + new String(rocksIterator.key())
                                + " , value = "
                                + new String(rocksIterator.value()));
                rocksIterator.next();
            }
        } catch (RocksDBException e) {
            e.printStackTrace();
        }

        // introduce thrift/pb
        // introduce node register
        // spotlesss & checkstyle
        // raft log entry
    }
}
