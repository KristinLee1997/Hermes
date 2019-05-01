package com.aries.hermes.server.thrift;

import com.aries.hera.client.thrift.ThriftHelper;
import com.aries.hera.contract.thrift.dto.ServiceInfo;
import com.aries.hera.contract.thrift.service.DiscoverService;
import com.aries.hermes.core.utils.PropertiesProxy;
import com.aries.hermes.idl.service.CategoryServer;
import com.aries.hermes.idl.service.ReplyServer;
import com.aries.hermes.idl.service.SubReplyServer;
import com.aries.hermes.idl.service.TopicServer;
import com.aries.hermes.server.thrift.server.CategoryServerImpl;
import com.aries.hermes.server.thrift.server.ReplyServerImpl;
import com.aries.hermes.server.thrift.server.SubReplyServerImpl;
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

            { // 准备注册 CategoryServer
                CategoryServer.Iface categoryServer = new CategoryServerImpl();
                CategoryServer.Processor categoryProcessor = new CategoryServer.Processor(categoryServer);
                String simpleName = CategoryServer.class.getSimpleName();
                log.info("simpleName:{}", simpleName);
                processor.registerProcessor(simpleName, categoryProcessor);
            }

            { // 准备注册 TopicServer
                TopicServer.Iface topicService = new TopicServerImpl();
                TopicServer.Processor topicProcessor = new TopicServer.Processor(topicService);
                String simpleName = TopicServer.class.getSimpleName();
                log.info("simpleName:{}", simpleName);
                processor.registerProcessor(simpleName, topicProcessor);
            }

            { // 准备注册 ReplyServer
                ReplyServer.Iface replyService = new ReplyServerImpl();
                ReplyServer.Processor replyProcessor = new ReplyServer.Processor(replyService);
                String simpleName = ReplyServer.class.getSimpleName();
                log.info("simpleName:{}", simpleName);
                processor.registerProcessor(simpleName, replyProcessor);
            }

            { // 准备注册 SubReplyServer
                SubReplyServer.Iface subReplyService = new SubReplyServerImpl();
                SubReplyServer.Processor subReplyProcessor = new SubReplyServer.Processor(subReplyService);
                String simpleName = SubReplyServer.class.getSimpleName();
                log.info("simpleName:{}", simpleName);
                processor.registerProcessor(simpleName, subReplyProcessor);
            }

            // 从配置文件获取端口 6022
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


            // 注册服务
            PropertiesProxy heraProperties = new PropertiesProxy("hera-reg-service.properties");
            String apphost = heraProperties.readProperty("apphost");
            ServiceInfo serviceInfo = new ServiceInfo();
            serviceInfo.setName("Hermes");
            serviceInfo.setHost(apphost);
            serviceInfo.setPort(port);
            ThriftHelper.call("Hera", DiscoverService.Client.class, client -> client.registe(serviceInfo));
            log.info("注册服务, appname:{}, host:{}, port:{}", "Hermes", apphost, port);
        } catch (Exception x) {
            log.error("创建服务失败,error:{}", x.getMessage(), x);
        }
    }
}