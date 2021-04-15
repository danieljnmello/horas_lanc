package br.com.hitssembratel.bpo.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hitssembratel.bpo.gercpe.repository.GerCpeAtividadesRepository;
import br.com.hitssembratel.bpo.service.BaseService;

/**
 * 
 * @author hedvelton.maiorino
 *
 */
@Service
public class BaseServiceImpl implements BaseService {

	@Autowired
	GerCpeAtividadesRepository gerCpeAtividadesRepository;

	public Calendar getSysDate() {
		Timestamp dataBanco = gerCpeAtividadesRepository.getSysDate();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
		String dataformatada = dateFormat.format(dataBanco);

		Calendar data = Calendar.getInstance();

		try {
			data.setTime(dateFormat.parse(dataformatada));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return data;
	}
}