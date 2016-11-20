package edu.rms.business.Impl;

import java.util.ArrayList;
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
	public List<String> getOneRAItems(int raid) {
		List<RaItems> temp=ridao.getOneRAItems(raid);
		List<String> re=new ArrayList<String>();
		if(temp==null){
			return null;
		}else{
		for(int i=0;i<temp.size();i++){
			re.add(String.valueOf(temp.get(i).getRiskItem_id()));
		}
		return re;
		}
	}

	@Override
	public String save(RaItems raitem) {
		
		return ridao.save(raitem);
	}

	@Override
	public List<RaItems> getOneRaItems(int raid) {
		// TODO Auto-generated method stub
		return ridao.getOneRAItems(raid);
	}

	

}
