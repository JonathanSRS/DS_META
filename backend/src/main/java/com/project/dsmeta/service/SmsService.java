package com.project.dsmeta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.project.dsmeta.entities.Sale;
import com.project.dsmeta.repositories.SalesRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {
	@Value("${twilio.sid}")
	private String twilioSid;
	
	@Value("${twilio.key}")
	private String twilioKey;
	
	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;
	
	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	@Autowired
	private SalesRepository saleRepository;
	
	public void sendSms(Long saleId) {
		//Buscar vendedor Por Id
		Sale sale = saleRepository.findById(saleId).get();
		
		String date = sale.getData().getMonthValue() + "/"+ sale.getData().getYear();
		//Mensagem Customizada
		String msg = "O Vendedor " + sale.getVendedor() + " foi destaque em " + date+
				" com um total de R$ "+String.format("%.2f", sale.getTotal());
		
		Twilio.init(twilioSid, twilioKey);
		
		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);
		
		Message message = Message.creator(to, from, msg).create();
		
		System.out.println(message.getSid());
	}

}
