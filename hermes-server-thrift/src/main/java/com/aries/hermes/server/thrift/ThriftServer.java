package com.aries.hermes.server.thrift;

import com.aries.hermes.core.utils.PropertiesProxy;
import com.aries.hermes.idl.service.TopicServer;
import com.aries.hermes.server.thrift.constants.ServerNameConst;
import com.aries.hermes.server.thrift.server.TopicServerImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

@Slf4j
public class ThriftServer {

    public void start() {
        try {
            TMultiplexedProcessor processor = new TMultiplexedProcessor();

            { // 准备注册 TopicServer
                TopicServer.Iface departmentService = new TopicServerImpl();
                TopicServer.Processor departmentProcessor = new TopicServer.Processor(departmentService);
                processor.registerProcessor(ServerNameConst.TOPIC_SERVER, departmentProcessor);
            }

            // 从配置文件获取端口 6001
            PropertiesProxy propertiesProxy = new PropertiesProxy("hermes-service.properties");
            int port = Integer.parseInt(propertiesProxy.readProperty("port"));

            // 设置端口
            TServerTransport serverTransport = new TServerSocket(port);
            TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));
            log.info("服务启动,端口:{}", port);

            // 用新线程开启服务。
            new Thread(() -> {
                try {
                    server.serve();
                } catch (Exception e) {
                    log.error("hermes服务异常,error:{}", e.getMessage(), e);
                }
            }, "thrift-service-starter-thread").start();

        } catch (Exception x) {
            log.error("创建服务失败,error:{}", x.getMessage(), x);
        }
    }
}