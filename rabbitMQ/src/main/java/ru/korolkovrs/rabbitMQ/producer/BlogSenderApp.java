package ru.korolkovrs.rabbitMQ.producer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class BlogSenderApp {
    private static final String EXCHANGE_NAME = "directExchanger";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        Scanner scanner = new Scanner(System.in);
        String tag;
        String message;

        while (true) {
            System.out.println("Enter message or enter -exit to exit:");
            tag = scanner.next();
            if (tag.equals("-exit")) {
                break;
            }
            message = scanner.nextLine().substring(1);
            channel.basicPublish(EXCHANGE_NAME, tag, null, message.getBytes("UTF-8"));
            System.out.println(String.format("[X] Sent '%s' with tag '%s'", message, tag));
        }
        scanner.close();
    }
}
