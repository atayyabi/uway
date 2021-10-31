package com.uway.server.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.mail.simplemail.SimpleEmailServiceJavaMailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;

public class SimpleMailConfig {

    @Value("${aws.access-key}")
    protected String accessKey;

    @Value("${aws.secret-key}")
    protected String secretKey;

    EndpointConfiguration endpointConfig = new AwsClientBuilder.EndpointConfiguration(
            "ses.us-east-2.amazonaws.com",
            "us-east-2"
    );


    @Bean
    public AmazonSimpleEmailService amazonSimpleEmailService() {
        return
                AmazonSimpleEmailServiceClientBuilder.standard()
                        .withEndpointConfiguration(endpointConfig)
                        .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
                        .withRegion(Regions.US_EAST_2)
                        .build();

    }

    @Bean
    public JavaMailSender mailSender(AmazonSimpleEmailService ses) {
        return new SimpleEmailServiceJavaMailSender(ses);

    }


}
