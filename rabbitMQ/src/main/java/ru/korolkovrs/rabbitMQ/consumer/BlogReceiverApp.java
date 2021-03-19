package ru.korolkovrs.rabbitMQ.consumer;

import com.rabbitmq.client.*;

import java.util.ArrayList;
import java.util.List;


public class BlogReceiverApp {
    private static final String EXCHANGE_NAME = "directExchanger";

    public static void main(String[] args) throws Exception {
        List<String> tags = new ArrayList<>();

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        String queueName = channel.queueDeclare().getQueue();

        Thread consoleListenThread = new Thread(new ConsumerConsoleListener(channel, EXCHANGE_NAME, queueName));
        consoleListenThread.start();

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
        };

        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {
        });
    }
}
