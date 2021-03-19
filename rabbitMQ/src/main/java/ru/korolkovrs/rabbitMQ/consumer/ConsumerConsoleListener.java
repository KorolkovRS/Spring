package ru.korolkovrs.rabbitMQ.consumer;

import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsumerConsoleListener implements Runnable {
    private Channel channel;
    private String exchangeName;
    private String queueName;
    private List<String> tags;

    public ConsumerConsoleListener(Channel channel, String exchangeName, String queueName) {
        this.channel = channel;
        this.exchangeName = exchangeName;
        this.queueName = queueName;
        tags = new ArrayList<>();
    }

    @Override
    public void run() {
        List<String> tags = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String tag;
        boolean isExit = false;

        while (!isExit) {
            System.out.println("Enter:" +
                    "\n1) -q to exit from console" +
                    "\n2) -list to print all tags" +
                    "\n3) -unsub 'tag' to unsubscribe tag" +
                    "\n4) -set_topic 'topicname' to subscribe tag");
            tag = scanner.next();
            switch (tag) {
                case "-list":
                    printList();
                    break;
                case "-unsub":
                    unsubscribe(scanner);
                    break;
                case "-set_topic":
                    subscribe(scanner);
                    break;
                case "-q":
                    System.out.println("Goodbye!");
                    isExit = true;
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }

    private void subscribe(Scanner scanner) {
        String tag = scanner.nextLine().substring(1);
        try {
            channel.queueBind(queueName, exchangeName, tag);
            tags.add(tag);
            System.out.println("Bind with tag: '" + tag + "'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void unsubscribe(Scanner scanner) {
        String tag = scanner.nextLine().substring(1);
        try {
            if (tags.contains(tag)) {
                channel.queueUnbind(queueName, exchangeName, tag);
                tags.remove(tag);
                System.out.println("Unbind with tag: '" + tag + "'.");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printList() {
        int i = 1;
        for (String tag : tags) {
            System.out.println(String.format("%d) %s", i, tag));
            i++;
        }
    }
}
