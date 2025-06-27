package aivlemini.scheduler;

import aivlemini.domain.UserInfo;
import aivlemini.UserserviceApplication;
import aivlemini.domain.UserInfoRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class PlanExpirationScheduler {

    private UserInfoRepository repository() {
        return UserserviceApplication.applicationContext.getBean(UserInfoRepository.class);
    }

    //@Scheduled(cron = "*/10 * * * * ?") 
    @Scheduled(cron = "0 0 0 * * ?")
    public void expireOldPlans() {
        Date now = new Date();

        List<UserInfo> expiredUsers = repository().findByPlanEndDateBeforeAndIsPurchaseTrue(now);
        for (UserInfo user : expiredUsers) {
            user.setIsPurchase(false);
            repository().save(user);
            System.out.println("요금제 만료 처리됨: userId = " + user.getId());
        }
    }
}
