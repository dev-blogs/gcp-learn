package org.example;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class App implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(App.class)
            .web(WebApplicationType.NONE)
            .run(args)
            .close();
    }

    @Override
    public void run(String [] args) {
        logger.info("list of buckets");
        listBuckets("my-test-project-371310");
    }

    public static void listBuckets(String projectId) {
        Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
        Page<Bucket> buckets = storage.list();

        for (Bucket bucket : buckets.iterateAll()) {
            logger.info(bucket.getName());
        }
    }
}
