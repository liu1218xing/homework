package homework;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.task.course.dao.PersonMapper;
import com.task.course.dao.TrxMapper;
import com.task.course.meta.Person;
import com.task.course.meta.Trx;



public class TestProductList {
	@Test
	public void testProdectList(){
//		//创建一个spring容器
//		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-*.xml");
//		//从spring容器中获得Mapper的代理对象
//		TrxMapper mapper =context.getBean(TrxMapper.class);
//		List<Trx> list = mapper.getAllTrx();
//		for(Trx trx:list){
//			System.out.println(trx.getId()+",contid:"+trx.getContentId());
//		}
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
		PersonMapper dao = context.getBean("personMapper", PersonMapper.class);
//		dao.createTable();
//		dao.insertData();
//		System.out.println(dao.getItemById(691300));
		System.out.println("hello");
		List<Person> list =  dao.getAllPerson();
		for(Person po:list){
			System.out.println(po.getUserName()+",md5:"+po.getPassword());
			
		}
		
	}
}
