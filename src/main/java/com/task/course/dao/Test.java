package com.task.course.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.task.course.meta.Content;
import com.task.course.meta.Person;
import com.task.course.meta.ProductList;
import com.task.course.meta.Trx;
import com.task.course.service.ProductService;




public class Test {
	public static void main(String[] args) throws Exception{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
		ContentMapper dao = context.getBean("contentMapper", ContentMapper.class);
//		dao.createTable();
//		dao.insertData();
//		System.out.println(dao.getItemById(691300));
		System.out.println("hello");
		Content content =new Content();
		content =  dao.getSingleConten(2);
		System.out.println(content.getId()+content.getTitle()+content.getDetail());
//		Trx trx = new Trx();
//		trx = dao.getpersonTrx(1);
//		trx = dao.getCurrPersonIsBuyTrx(1,1);
//		System.out.println(trx.getPersonId()+",cid:"+trx.getContentId());
			
		
        
			System.out.println(System.currentTimeMillis());
			long beginDate= 1459064247544L; 
			String beingD = Long.toString(beginDate);
//			2016-03-27 15:37:027
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");  
	        String sd = sdf.format(new Date(Long.parseLong(beingD)));  
	         try {
	            Date date = sdf.parse(sd);
	            System.out.println(sdf.format(date));  
	        } catch (ParseException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
		((ConfigurableApplicationContext)context).close();
	}
}
