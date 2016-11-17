package edu.rms.businessImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rms.business.RaItemsBusiness;
import edu.rms.dao.RaItemsDao;
import edu.rms.model.RaItems;


@Service
public class RaItemsBusinessImpl implements RaItemsBusiness{

	
	@Autowired
	private RaItemsDao ridao;
	@Override
	public List<RaItems> getOneRAItems(int raid) {
		
		return ridao.getOneRAItems(raid);
	}

	@Override
	public String save(RaItems raitem) {
		
		return ridao.save(raitem);
	}

}
