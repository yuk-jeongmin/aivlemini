package aivlemini.infra;

import aivlemini.config.kafka.KafkaProcessor;
import aivlemini.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    UserInfoRepository userInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='AppliesFailed'"
    )
    public void wheneverAppliesFailed_GuidePlan(
        @Payload AppliesFailed appliesFailed
    ) {
        AppliesFailed event = appliesFailed;
        System.out.println(
            "\n\n##### listener GuidePlan : " + appliesFailed + "\n\n"
        );

        // Sample Logic //
        UserInfo.guidePlan(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
