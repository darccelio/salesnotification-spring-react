package com.devsuperior.dsmeta.services.impl;


import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
@RequiredArgsConstructor
public class SmsServiceImpl {

    final private SaleRepository saleRepository;
    @Value("${twilio.sid}")
    private String twilioSid;
    @Value("${twilio.key}")
    private String twilioKey;
    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;
    @Value("${twilio.phone.to}")
    private String twilioPhoneTo;

    public void sendSms(Long saleId) {

        Sale sale = saleRepository.findById(saleId).get();

        Twilio.init(twilioSid, twilioKey);
        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);
        Message message = Message.creator(to, from, String.valueOf(sale)).create();

        System.out.println(message.getSid());
    }

}