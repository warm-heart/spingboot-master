package com.example.mybatis.mqtt;



import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;


/**
 * @author wangqianlong
 * @create 2018-07-15 11:15
 */

public class Server {

    public static final String HOST = "tcp://127.0.0.1:61613";
    public static final String TOPIC1 = "toclient/1";
    public static final String TOPIC2 = "toclient/2";
    private static final String clientid = "server";

    private MqttClient client;
    private MqttTopic topic1;
    private MqttTopic topic2;
    private String userName = "admin";
    private String passWord = "password";

    private MqttMessage message;

    public Server() throws MqttException {
        // MemoryPersistence设置clientid的保存形式，默认为以内存保存
        client = new MqttClient(HOST, clientid, new MemoryPersistence());
        connect();
    }

    private void connect() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(false);
        options.setUserName(userName);
        options.setPassword(passWord.toCharArray());
        // 设置超时时间
        options.setConnectionTimeout(10);
        // 设置会话心跳时间
        options.setKeepAliveInterval(20);
        try {
            client.setCallback(new PushCallback());
            client.connect(options);
            topic1 = client.getTopic(TOPIC1);
            topic2 = client.getTopic(TOPIC2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void publish(MqttTopic topic , MqttMessage message) throws MqttPersistenceException,
            MqttException {
        MqttDeliveryToken token = topic.publish(message);
        token.waitForCompletion();
        System.out.println("信息已完全发布 "
                + token.isComplete());
    }

    public static void main(String[] args) throws MqttException {
        Server server = new Server();

        server.message = new MqttMessage();
        server.message.setQos(2);
        server.message.setRetained(true);
        server.message.setPayload("hello 1".getBytes());
        server.publish(server.topic1 , server.message);

        server.message = new MqttMessage();
        server.message.setQos(2);
        server.message.setRetained(true);
        server.message.setPayload("hello 2".getBytes());
        server.publish(server.topic2 , server.message);

        System.out.println(server.message.isRetained() + "------ratained状态");
    }
}
