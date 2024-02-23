package myKhdsPay.banking.adaptor.out.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import myKhdsPay.banking.application.port.out.GetMembershipPort;
import myKhdsPay.banking.application.port.out.MemberShipStatus;
import myKhdsPay.common.CommonHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MembershipServiceAdapter implements GetMembershipPort {

    private final CommonHttpClient commonHttpClient;

    private final String membershipServiceUrl;

    public MembershipServiceAdapter(CommonHttpClient commonHttpClient,
        @Value("${service.membership.url}") String membershipServiceUrl) {
        this.commonHttpClient = commonHttpClient;
        this.membershipServiceUrl = membershipServiceUrl;
    }

    @Override
    public MemberShipStatus getMembership(String membershipId) throws Exception {

        // 실제 http call
        // we need http client class
        String url = String.join("/", membershipServiceUrl, "membership/find" + membershipId);
        try {
            String jsonResponse = commonHttpClient.sendGetRequest(url).body();

            ObjectMapper objectMapper = new ObjectMapper();
            Membership membership = objectMapper.readValue(jsonResponse, Membership.class);

            if (membership.isValid()) {
                return new MemberShipStatus(membershipId, true);
            } else {
                return new MemberShipStatus(membershipId, false);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while calling membership service", e);
        }
    }
}
