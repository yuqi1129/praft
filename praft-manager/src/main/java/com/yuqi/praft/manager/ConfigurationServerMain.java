/* (C)2021 */
package com.yuqi.praft.manager;

/**
 * @author yuqi
 * @mail yuqi4733@gmail.com
 * @description your description
 * @time 22/1/21 下午8:01
 */
public class ConfigurationServerMain {
    public static void main(String[] args) {
        // some parameter
        int port = 3100;
        ConfigurationCenter configurationCenter = new ConfigurationCenter(port);
        configurationCenter.start();
    }
}
