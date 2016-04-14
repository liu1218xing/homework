package com.task.course.dao;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialBlob;

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
		
		
		
		Content content = new Content();

		 
//		String details = new String("你好，中文");
//		
//		content.setDetail(details.getBytes("UTF-8"));
//		content.setImage("hwefewf");
//		content.setPrice(12);
//		content.setSummary("sfdsfdsf");
//		content.setTitle("ttitle");
//		dao.addConten(content);
//		System.out.println(details.getBytes("UTF-8"));
//		System.out.println("hello");
		content =  dao.getSingleConten(4);
		String details = new String(content.getDetail(),"UTF-8");
		System.out.println("detail:"+details);
		 Object detail = content.getDetail();
		 
		 
//		Blob blob = (Blob)content.getDetail();
//		 OutputStream ops = null; 
		
//		Blob blob =new SerialBlob((byte[]) content.getDetail()); 
//		////////////////
//		byte[] returnValue = null;
//	    if (null != blob) {
//	      returnValue = detail.getBytes(1, (int) detail.length());
//	    }
//	    System.out.println("ret:"+returnValue);
	    
//	    return returnValue;
		/////////////////
//		long blobLength = detail.length();
//		String s = detail.toString();
//		
//		System.out.println(s);
		
//		try{  
//	         String content_s1 = new String(blob.getBytes((long)1, (int)blob.length()));  
//	         System.out.println(content_s1);
//	    } catch(SQLException e) {  
//	         e.printStackTrace();  
//	    }   
//		System.out.println(content.getId()+content.getTitle()+"d:"+detail);
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
